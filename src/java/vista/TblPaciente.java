/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author niels
 */
@Entity
@Table(name = "tbl_paciente")
@NamedQueries({
    @NamedQuery(name = "TblPaciente.findAll", query = "SELECT t FROM TblPaciente t"),
    @NamedQuery(name = "TblPaciente.findByPkidPaciente", query = "SELECT t FROM TblPaciente t WHERE t.pkidPaciente = :pkidPaciente"),
    @NamedQuery(name = "TblPaciente.findByNombrePaci", query = "SELECT t FROM TblPaciente t WHERE t.nombrePaci = :nombrePaci"),
    @NamedQuery(name = "TblPaciente.findByApellidoPaci", query = "SELECT t FROM TblPaciente t WHERE t.apellidoPaci = :apellidoPaci"),
    @NamedQuery(name = "TblPaciente.findByFechaNacimiento", query = "SELECT t FROM TblPaciente t WHERE t.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "TblPaciente.findByGenero", query = "SELECT t FROM TblPaciente t WHERE t.genero = :genero"),
    @NamedQuery(name = "TblPaciente.findByDireccionPAci", query = "SELECT t FROM TblPaciente t WHERE t.direccionPAci = :direccionPAci"),
    @NamedQuery(name = "TblPaciente.findByTelefono", query = "SELECT t FROM TblPaciente t WHERE t.telefono = :telefono"),
    @NamedQuery(name = "TblPaciente.findByEstadoPaci", query = "SELECT t FROM TblPaciente t WHERE t.estadoPaci = :estadoPaci")})
public class TblPaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pk_idPaciente")
    private Integer pkidPaciente;
    @Column(name = "nombrePaci")
    private String nombrePaci;
    @Column(name = "apellidoPaci")
    private String apellidoPaci;
    @Column(name = "FechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "Genero")
    private Integer genero;
    @Column(name = "direccionPAci")
    private String direccionPAci;
    @Column(name = "Telefono")
    private Integer telefono;
    @Column(name = "estadoPaci")
    private Integer estadoPaci;
    @JoinColumn(name = "fk_idReferencia", referencedColumnName = "pk_idReferencia")
    @ManyToOne(optional = false)
    private TblReferencias fkidReferencia;
    @OneToMany(mappedBy = "fkidPaciente")
    private Collection<TblEncabezadofactura> tblEncabezadofacturaCollection;

    public TblPaciente() {
    }

    public TblPaciente(Integer pkidPaciente) {
        this.pkidPaciente = pkidPaciente;
    }

    public Integer getPkidPaciente() {
        return pkidPaciente;
    }

    public void setPkidPaciente(Integer pkidPaciente) {
        this.pkidPaciente = pkidPaciente;
    }

    public String getNombrePaci() {
        return nombrePaci;
    }

    public void setNombrePaci(String nombrePaci) {
        this.nombrePaci = nombrePaci;
    }

    public String getApellidoPaci() {
        return apellidoPaci;
    }

    public void setApellidoPaci(String apellidoPaci) {
        this.apellidoPaci = apellidoPaci;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getGenero() {
        return genero;
    }

    public void setGenero(Integer genero) {
        this.genero = genero;
    }

    public String getDireccionPAci() {
        return direccionPAci;
    }

    public void setDireccionPAci(String direccionPAci) {
        this.direccionPAci = direccionPAci;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getEstadoPaci() {
        return estadoPaci;
    }

    public void setEstadoPaci(Integer estadoPaci) {
        this.estadoPaci = estadoPaci;
    }

    public TblReferencias getFkidReferencia() {
        return fkidReferencia;
    }

    public void setFkidReferencia(TblReferencias fkidReferencia) {
        this.fkidReferencia = fkidReferencia;
    }

    public Collection<TblEncabezadofactura> getTblEncabezadofacturaCollection() {
        return tblEncabezadofacturaCollection;
    }

    public void setTblEncabezadofacturaCollection(Collection<TblEncabezadofactura> tblEncabezadofacturaCollection) {
        this.tblEncabezadofacturaCollection = tblEncabezadofacturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidPaciente != null ? pkidPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPaciente)) {
            return false;
        }
        TblPaciente other = (TblPaciente) object;
        if ((this.pkidPaciente == null && other.pkidPaciente != null) || (this.pkidPaciente != null && !this.pkidPaciente.equals(other.pkidPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vista.TblPaciente[ pkidPaciente=" + pkidPaciente + " ]";
    }
    
}
