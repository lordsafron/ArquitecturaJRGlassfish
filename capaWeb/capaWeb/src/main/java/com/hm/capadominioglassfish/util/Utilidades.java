/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.capadominioglassfish.util;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author HugoM
 */
public class Utilidades {
    
    public static Object getEJBRemote(String nameEJB, String iface) throws Exception {
        Context context;
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        props.put(Context.PROVIDER_URL, "http://localhost:4949");
        try {
            context = new InitialContext(props);
            String lookup = nameEJB+"#"+iface;
            System.out.println("Looup: " + lookup);
            return context.lookup(lookup);
        } catch (Exception ex) {
            throw new Exception("No se encontro el EJB: '"+nameEJB+"'." );
        }
    }
    
}
