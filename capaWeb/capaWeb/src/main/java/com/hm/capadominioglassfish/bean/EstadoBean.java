/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.capadominioglassfish.bean;

import com.hm.capadominioglassfish.entities.Estado;
import com.hm.capadominioglassfish.servicio.ServiceEstado;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;





/**
 *
 * @author HugoM
 */
@ManagedBean(name = "estadoBean")
public class EstadoBean {
    
    private Estado estado;
    
    @EJB
    private ServiceEstado serviceEstado;
    
    

    /**
     * @return the estado
     */
    public Estado getEstado() throws Exception {
        return serviceEstado.findById(1);
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * @return the serviceEstado
     */
    public ServiceEstado getServiceEstado() {
        return serviceEstado;
    }

    /**
     * @param serviceEstado the serviceEstado to set
     */
    public void setServiceEstado(ServiceEstado serviceEstado) {
        this.serviceEstado = serviceEstado;
    }
    
    
    
}
