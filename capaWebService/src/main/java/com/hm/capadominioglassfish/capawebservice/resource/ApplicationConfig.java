/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.capadominioglassfish.capawebservice.resource;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author HugoM
 */
@ApplicationPath("rest")
public class ApplicationConfig extends Application {
    
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new java.util.HashSet<>();
        addResourceClasses(resources);
        return resources;
    }

    private void addResourceClasses(Set<Class<?>> resources) {
        resources.add(com.hm.capadominioglassfish.capawebservice.resource.EstadoResource.class);
        resources.add(com.hm.capadominioglassfish.capawebservice.resource.MunicipioResource.class);
    }
    
}
