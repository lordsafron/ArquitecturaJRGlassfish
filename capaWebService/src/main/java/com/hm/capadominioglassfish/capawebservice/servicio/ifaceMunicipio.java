/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.capadominioglassfish.capawebservice.servicio;

import com.hm.capadominioglassfish.entities.Municipio;
import javax.ejb.Remote;

/**
 *
 * @author HugoM
 */
@Remote
public interface ifaceMunicipio {
    
    public Municipio findById(int idMunicipio) throws Exception;
    
}
