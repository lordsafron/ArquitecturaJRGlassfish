/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.capadominioglassfish.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author HugoM
 */
@Entity
@Table(name = "CIUDAD")
@NamedQueries({
    @NamedQuery(
            name = "Ciudad.findById",
            query = "SELECT c FROM Ciudad c WHERE c.idCiudad = :ciIdCiudad")
})
public class Ciudad implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public static final String FIND_BY_ID = "Ciudad.findById";
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;
    
    @Id
    @Column(name = "id_ciudad")
    private int idCiudad;
    
    @Column(name = "descripcion_ciudad")
    private String descripcionCiudad;
    
    @Column(name = "nombre_ciudad")
    private String nombreCiudad;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_fundada")
    private Date fechaFundada;
    
    public Ciudad(){
        
    }

    public Ciudad(Municipio municipio, int idCiudad, String descripcionCiudad, String nombreCiudad, Date fechaFundada) {
        this.municipio = municipio;
        this.idCiudad = idCiudad;
        this.descripcionCiudad = descripcionCiudad;
        this.nombreCiudad = nombreCiudad;
        this.fechaFundada = fechaFundada;
    }

    

    
    /**
     * @return the estado
     */
    public Municipio getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
    

    /**
     * @return the idCiudad
     */
    public int getIdCiudad() {
        return idCiudad;
    }

    /**
     * @param idCiudad the idCiudad to set
     */
    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    /**
     * @return the descripcionCiudad
     */
    public String getDescripcionCiudad() {
        return descripcionCiudad;
    }

    /**
     * @param descripcionCiudad the descripcionCiudad to set
     */
    public void setDescripcionCiudad(String descripcionCiudad) {
        this.descripcionCiudad = descripcionCiudad;
    }
    
    /**
     * @return the nombreCiudad
     */
    public String getNombreCiudad() {
        return nombreCiudad;
    }

    /**
     * @param nombreCiudad the nombreCiudad to set
     */
    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    /**
     * @return the fechaFundada
     */
    public Date getFechaFundada() {
        return fechaFundada;
    }

    /**
     * @param fechaFundada the fechaFundada to set
     */
    public void setFechaFundada(Date fechaFundada) {
        this.fechaFundada = fechaFundada;
    }

    @Override
    public String toString() {
        return "Ciudad{" + "municipio=" + municipio + ", idCiudad=" + idCiudad + ", descripcionCiudad=" + descripcionCiudad + ", nombreCiudad=" + nombreCiudad + ", fechaFundada=" + fechaFundada + '}';
    }

       
    
    
}
