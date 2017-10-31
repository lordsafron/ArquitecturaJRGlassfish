/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.capadominioglassfish.capawebservice.servicio;

import com.hm.capadominioglassfish.entities.Estado;
import com.hm.capadominioglassfish.negocio.NegocioEstado;
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
public class ServiceEstado implements ifaceEstado{

    @EJB(lookup = "java:global/CapaProcesamiento-ear/CapaProcesamiento-ejb-1/EstadoEJB!com.hm.capadominioglassfish.negocio.NegocioEstado")
    NegocioEstado ejb;
    
    Context context;
    
    @Override
    public Estado findById(int idEstado) throws Exception {
        Estado estado = ejb.findById(idEstado);
        return estado;
    }
    
}
