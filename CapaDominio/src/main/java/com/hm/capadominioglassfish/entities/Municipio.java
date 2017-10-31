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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HugoM
 */
@Entity
@Table(name = "MUNICIPIO")
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@NamedQueries({
    @NamedQuery(
            name = "Municipio.findById",
            query = "SELECT m FROM Municipio m WHERE m.idMunicipio = :idMunicipio"),
    @NamedQuery(
            name = "Municipio.findByCiudad",
            query = "SELECT m FROM Municipio m WHERE m.estado.idEstado = :ciEstado")
})
public class Municipio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public static final String FIND_BY_ID = "Municipio.findById";
    
    public static final String FIND_BY_CITY = "Municipio.findByCiudad";
    
    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;
    
    @Id
    @Column(name = "id_municipio")
    private int idMunicipio;
    
    @Column(name = "descripcion_municipio")
    @XmlElement(name = "descripcionMunicipio")
    private String descripcionMunicipio;
    
    @Column(name = "nombre_municipio")
    @XmlElement(name = "nombreMunicipio")
    private String nombreMunicipio;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_fundacion_m")
    @XmlElement(name = "fechaFundacionM")
    private Date fechaFundacionM;
    
    /**
     * @return the nombreMunicipio
     */
    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    /**
     * @param nombreMunicipio the nombreMunicipio to set
     */
    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    /**
     * @return the fechaFundacionM
     */
    public Date getFechaFundacionM() {
        return fechaFundacionM;
    }

    /**
     * @param fechaFundacionM the fechaFundacionM to set
     */
    public void setFechaFundacionM(Date fechaFundacionM) {
        this.fechaFundacionM = fechaFundacionM;
    }
    
    public Municipio(){
        
    }

    public Municipio(Estado estado, int idMunicipio, String descripcionMunicipio, String nombreMunicipio, Date fechaFundacionM) {
        this.estado = estado;
        this.idMunicipio = idMunicipio;
        this.descripcionMunicipio = descripcionMunicipio;
        this.nombreMunicipio = nombreMunicipio;
        this.fechaFundacionM = fechaFundacionM;
    }

    

    

    

    /**
     * @return the idCiudad
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * @return the idMunicipio
     */
    public int getIdMunicipio() {
        return idMunicipio;
    }

    /**
     * @param idMunicipio the idMunicipio to set
     */
    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    /**
     * @return the descripcionMunicipio
     */
    public String getDescripcionMunicipio() {
        return descripcionMunicipio;
    }

    /**
     * @param descripcionMunicipio the descripcionMunicipio to set
     */
    public void setDescripcionMunicipio(String descripcionMunicipio) {
        this.descripcionMunicipio = descripcionMunicipio;
    }

    @Override
    public String toString() {
        return "Municipio{" + "estado=" + estado + ", idMunicipio=" + idMunicipio + ", descripcionMunicipio=" + descripcionMunicipio + '}';
    }

    
    
    
    
}
