package com.hm.capadominioglassfish.negocio;



import com.hm.capadominioglassfish.entities.Estado;
import javax.ejb.Remote;

@Remote
public interface NegocioEstado{
    
    public Estado findById(int idEstado) throws Exception;
    
}
