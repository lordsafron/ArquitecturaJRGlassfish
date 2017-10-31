/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.capadominioglassfish.ejb;

import com.hm.capadominioglassfish.commons.AbstractDAO;
import com.hm.capadominioglassfish.entities.Estado;
import com.hm.capadominioglassfish.entities.Municipio;
import com.hm.capadominioglassfish.negocio.NegocioEstado;
import com.hm.capadominioglassfish.negocio.NegocioMunicipio;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author HugoM
 */
@Stateless(mappedName = "ejbMunicipio")
public class MunicipioEJB extends AbstractDAO<Municipio> implements NegocioMunicipio {

    
    public MunicipioEJB(){
        super(Municipio.class);
    }
    @Override
    public Municipio findById(int idMunicipio) throws Exception {
        Map<String, Object> parameter = new HashMap<String, Object>();
        Municipio municipio = new Municipio();
        
        try {
            parameter.put("idMunicipio", idMunicipio);
            
            municipio = super.findOneResult(Municipio.FIND_BY_ID, parameter);
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return municipio;
    }
    
}
