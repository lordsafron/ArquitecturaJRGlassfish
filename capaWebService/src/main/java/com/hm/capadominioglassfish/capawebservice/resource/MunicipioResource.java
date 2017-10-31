/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.capadominioglassfish.capawebservice.resource;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hm.capadominioglassfish.capawebservice.servicio.ServiceMunicipio;
import com.hm.capadominioglassfish.entities.Estado;
import com.hm.capadominioglassfish.entities.Municipio;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author HugoM
 */
@Stateless
@Path("municipio")
public class MunicipioResource {
    
    @EJB
    private ServiceMunicipio serviceMunicipio;
    private Gson gson = new Gson();
    private String json;
    private Municipio municipio;
    
    @GET
    @Path("findById/{idMunicipio}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getByIdEstados(@PathParam("idMunicipio") int idMunicipio) throws Exception {
        System.out.println("idMunicipio: " + idMunicipio);
        municipio = new Municipio();

   
            municipio = serviceMunicipio.findById(idMunicipio);

            json = gson.toJson(municipio, Estado.class);
            JsonElement nombreClass = gson.toJsonTree(municipio);
            JsonObject cuerpoClass = new JsonObject();
            cuerpoClass.add("municipio", nombreClass);
       

        return Response.ok().entity(municipio).build();

    }
    
}
