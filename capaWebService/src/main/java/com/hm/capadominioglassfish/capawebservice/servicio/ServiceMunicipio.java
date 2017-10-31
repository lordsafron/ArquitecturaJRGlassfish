/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.capadominioglassfish.capawebservice.servicio;

import com.hm.capadominioglassfish.entities.Estado;
import com.hm.capadominioglassfish.entities.Municipio;
import com.hm.capadominioglassfish.negocio.NegocioEstado;
import com.hm.capadominioglassfish.negocio.NegocioMunicipio;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.Context;

/**
 *
 * @author HugoM
 */

@Stateless
@LocalBean
public class ServiceMunicipio implements ifaceMunicipio{
    
    @EJB(lookup = "java:global/CapaProcesamiento-ear/CapaProcesamiento-ejb-1/MunicipioEJB!com.hm.capadominioglassfish.negocio.NegocioMunicipio")
    NegocioMunicipio ejb;
    
    Context context;
    
    @Override
    public Municipio findById(int idMunicipio) throws Exception {
        Municipio municipio = ejb.findById(idMunicipio);
        return municipio;
    }
    
}
