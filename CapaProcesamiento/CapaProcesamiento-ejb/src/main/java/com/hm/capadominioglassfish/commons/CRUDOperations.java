/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.capadominioglassfish.commons;

import java.util.List;

/**
 *
 * @author HugoM
 */
public interface CRUDOperations<T> {
    
    public void save(T entity);
    
    public void delete(Object id, Class<T> classe);
    
    public T update(T entity);
    
    public T findReferenceOnly(int entityID);
    
    public List<T> findAll();
    
}
