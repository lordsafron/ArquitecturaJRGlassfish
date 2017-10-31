/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.capadominioglassfish.ejb;

import com.hm.capadominioglassfish.commons.AbstractDAO;
import com.hm.capadominioglassfish.entities.Estado;
import com.hm.capadominioglassfish.negocio.NegocioEstado;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author HugoM
 */
@Stateless(mappedName = "ejbEstado")
public class EstadoEJB extends AbstractDAO<Estado> implements NegocioEstado {
    
    public EstadoEJB(){
        super(Estado.class);
    }

    @Override
    public Estado findById(int ciEstado) throws Exception {
        Map<String, Object> parameter = new HashMap<String, Object>();
        Estado estado = new Estado();
        
        
        try {
            parameter.put("ciEstado", ciEstado);
            
            estado = super.findOneResult(Estado.FIND_BY_ID, parameter);
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return estado;
    }
    
    
    
}
