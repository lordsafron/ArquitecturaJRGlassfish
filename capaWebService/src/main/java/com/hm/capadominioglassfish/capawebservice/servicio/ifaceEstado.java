/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.capadominioglassfish.capawebservice.servicio;

import com.hm.capadominioglassfish.entities.Estado;
import javax.ejb.Remote;



/**
 *
 * @author HugoM
 */
@Remote
public interface ifaceEstado {
    
    public Estado findById(int idEstado) throws Exception;
    
}
