package com.hm.capadominioglassfish.entities;

//import com.hm.capadominio.dto.EstadoDTO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ESTADO")
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@NamedQueries({
    @NamedQuery(name = "Estado.findById",
            query = "SELECT e FROM Estado e WHERE e.idEstado = :ciEstado")
})
public class Estado implements Serializable {
    
    private static long serialVersionUID = 1L;
    
    public static String FIND_BY_ID = "Estado.findById";
    
    @Id
    @Column(name = "id_estado")
    //@XmlElement(name = "idEstado")
    private int idEstado;
    
    @Column(name = "nombre_estado")
    @XmlElement(name = "nombreEstado")
    private String nombreEstado;
    
    @Column(name = "descripcion_estado")
    @XmlElement(name = "descripcionEstado")
    private String descripcionEstado;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_fundado")
    @XmlElement(name = "fechaDeFundado")
    private Date fechaDeFundado;
    
    public Estado(){
        
    }

    public Estado(int idEstado, String nombreEstado, String descripcionEstado, Date fechaDeFundado) {
        this.idEstado = idEstado;
        this.nombreEstado = nombreEstado;
        this.descripcionEstado = descripcionEstado;
        this.fechaDeFundado = fechaDeFundado;
    }

    /**
     * @return the id_estado
     */
    public int getIdEstado() {
        return idEstado;
    }

    /**
     * @param idEstado the id_estado to set
     */
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    /**
     * @return the nombreEstado
     */
    public String getNombreEstado() {
        return nombreEstado;
    }

    /**
     * @param nombreEstado the nombreEstado to set
     */
    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    /**
     * @return the descripcionEstado
     */
    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    /**
     * @param descripcionEstado the descripcionEstado to set
     */
    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    /**
     * @return the fechaDeFundado
     */
    public Date getFechaDeFundado() {
        return fechaDeFundado;
    }

    /**
     * @param fechaDeFundado the fechaDeFundado to set
     */
    public void setFechaDeFundado(Date fechaDeFundado) {
        this.fechaDeFundado = fechaDeFundado;
    }

    @Override
    public String toString() {
        return "Estado{" + "idEstado=" + idEstado + ", nombreEstado=" + nombreEstado + ", descripcionEstado=" + descripcionEstado + ", fechaDeFundado=" + fechaDeFundado + '}';
    }
    /*
    public EstadoDTO toConvertEstadoDTO(){
        
        EstadoDTO estadoDTO = new EstadoDTO();
        estadoDTO.setIdEstado(idEstado);
        estadoDTO.setNombreEstado(nombreEstado);
        estadoDTO.setDescripcionEstado(descripcionEstado);
        estadoDTO.setFechaDeFundado(fechaDeFundado);
        
        return estadoDTO;
        
    }
    */
    
}
