package com.hm.capadominioglassfish.capawebservice.resource;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hm.capadominioglassfish.capawebservice.servicio.ServiceEstado;
import com.hm.capadominioglassfish.entities.Estado;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("estado")
public class EstadoResource {

    @EJB
    private ServiceEstado serviceEstado;
    private Gson gson = new Gson();
    private String json;
    private Estado estado;

    
        
    @GET
    @Path("findById/{idEstado}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getByIdEstados(@PathParam("idEstado") int idEstado) throws Exception {
        System.out.println("idEstado: " + idEstado);
        estado = new Estado();

   
            estado = serviceEstado.findById(idEstado);

            json = gson.toJson(estado, Estado.class);
            JsonElement nombreClass = gson.toJsonTree(estado);
            JsonObject cuerpoClass = new JsonObject();
            cuerpoClass.add("estado", nombreClass);
       

        return Response.ok().entity(estado).build();

    }
    /*
    @GET
    @Path("findById/{idEstado}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getByIdEstados(@PathParam("idEstado") int idEstado) throws Exception {
        System.out.println("idEstado: " + idEstado);
        estado = new Estado();

   
            estado = serviceEstado.findById(idEstado);

            json = gson.toJson(estado, Estado.class);
            JsonElement nombreClass = gson.toJsonTree(estado);
            JsonObject cuerpoClass = new JsonObject();
            cuerpoClass.add("estado", nombreClass);
       

        return Response.ok().entity(cuerpoClass.toString())
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, PUT, POST")
                .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization,   Content-Type, X-Requested-With")
                .build();

    }
    */
    @GET
    @Path("prueba")
    @Produces(MediaType.APPLICATION_XML)
    public EntidadPersona getDatos(){
        return new EntidadPersona();
    }

}
