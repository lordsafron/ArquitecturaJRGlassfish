/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.capadominioglassfish.commons;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author HugoM
 */
@Stateless
public class AbstractDAO<T> implements Serializable, CRUDOperations<T> {
    
    private static final long serialVersionUID = 1L;
    
    @PersistenceContext(name = "ciudadPersistencia")
    private EntityManager em;
    
    private Class<T> entityClass;
    
    public AbstractDAO(){
        
    }
    
    public AbstractDAO(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    public EntityManager getEntityManager() {
        return em;
    }
    
    public void save(T entity) {
        em.persist(entity);
    }
    
    public void detach(T entity) {
        em.detach(entity);
    }
    
    
    public void delete(Object id, Class<T> classe) {
        T entityToBeRemoved = em.getReference(classe, id);
        
        em.remove(entityToBeRemoved);
    }
    
    public T update(T entity) {
        return em.merge(entity);
    }
    
    public T find(int entityID) {
		return em.find(entityClass, entityID);
    }
    
    public T findReferenceOnly(int entityID) {
		return em.getReference(entityClass, entityID);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findAll() {
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		
		return em.createQuery(cq).getResultList();
    }
        
    @SuppressWarnings("unchecked")
	public List<Object[]> findByNetiveQuery(String nativeQuery, 
			String mappingName, Map<Integer, Object> parameters) {
		List<Object[]> result = null;
		try {
			
			Query query = em.createNativeQuery(nativeQuery, mappingName);
			// Method that will populate parameters if they are passed not null
			// and empty
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryPositionalParameters(query, parameters);
			}
			result = query.getResultList();
			
		}
		catch (NoResultException e) {
			System.out.println("No result found for query: " + nativeQuery);
		} catch (Exception e) {
			System.out.println("Error while running query: " + e.getMessage());
			e.printStackTrace();
		}
		
		return result; 
	}
        
        @SuppressWarnings("unchecked")
	public List<T> findBy(String namedQuery, Map<String, Object> parameters) {
		List<T> result = null;
		
		try {
			Query query = em.createNamedQuery(namedQuery);
			
			// Method that will populate parameters if they are passed not 
			//null and empty
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}
			
			result = (List<T>) query.getResultList();
		}
		catch (NoResultException e) {
			System.out.println("No result found for named query: " +namedQuery);
		} catch (Exception e) {
			System.out.println("Error while running query: " + e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}
        
        @SuppressWarnings("unchecked")
	protected T findOneResult(String namedQuery, Map<String, Object>
		parameters) {
		T result = null;

		try {
			Query query = em.createNamedQuery(namedQuery);

			// Method that will populate parameters if they are passed not null 
			//and empty
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}

			result = (T) query.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("No result found for named query: " +namedQuery);
		} catch (Exception e) {
			System.out.println("Error while running query: " + e.getMessage());
			e.printStackTrace();
		}

		return result;
	}
        
        @SuppressWarnings("unchecked")
	protected T findOne(String queryString, 
			Map<String, Object> parameters) {
		 T result = null;
		try {
		Query query = em.createQuery(queryString);

			// Method that will populate parameters if they are passed not null 
			// and empty
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}
			result = (T) query.getSingleResult();
		} catch (NoResultException e) {
				System.out.println("No result found for query: " + queryString);
		} catch (Exception e) {
				System.out.println("Error while running query: " 
					+ e.getMessage());
				e.printStackTrace();
		}

		return result;
	}
        
        protected Object findOneObject(String queryString, 
			Map<String, Object> parameters) {
		 Object result = null;
		try {
		Query query = em.createQuery(queryString);

			// Method that will populate parameters if they are passed 
			// not null and empty
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}
			result =  query.getSingleResult();
		} catch (NoResultException e) {
				System.out.println("No result found for query: " + queryString);
		} catch (Exception e) {
				System.out.println("Error while running query: " 
					+ e.getMessage());
				e.printStackTrace();
		}

		return result;
	}
        
        public int update(String updateQuery, Map<String, Object> parameters) {
		int result = 0;
		
		try {
			Query query = em.createQuery(updateQuery);
			
			// Method that will populate parameters if they are passed not null 
			// and empty
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}
			
			result =  query.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error while running update: " + e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}
        
        private void populateQueryParameters(Query query, Map<String, Object> 
		parameters) {
		for (Entry<String, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}
        
        private void populateQueryPositionalParameters(Query query, 
			Map<Integer, Object> parameters) {
		for (Entry<Integer, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}
        
        public boolean isOpen() {
		return em.isOpen();
	}

	public void beginTransaction() {
		em.getTransaction().begin();
	}

	public void joinTransaction() {
		em.joinTransaction();
	}

	public void commit() {
		em.getTransaction().commit();
	}

	public void rollback() {
		em.getTransaction().rollback();
	}

	public void closeTransaction() {
		em.close();
	}

	public void commitAndCloseTransaction() {
		commit();
		closeTransaction();
	}

	public void flush() {
		em.flush();
	}
    
}
