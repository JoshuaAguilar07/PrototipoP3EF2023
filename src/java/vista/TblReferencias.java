/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author niels
 */
@Entity
@Table(name = "tbl_referencias")
@NamedQueries({
    @NamedQuery(name = "TblReferencias.findAll", query = "SELECT t FROM TblReferencias t"),
    @NamedQuery(name = "TblReferencias.findByPkidReferencia", query = "SELECT t FROM TblReferencias t WHERE t.pkidReferencia = :pkidReferencia"),
    @NamedQuery(name = "TblReferencias.findByDescripcion", query = "SELECT t FROM TblReferencias t WHERE t.descripcion = :descripcion")})
public class TblReferencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pk_idReferencia")
    private Integer pkidReferencia;
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkidReferencia")
    private Collection<TblPaciente> tblPacienteCollection;

    public TblReferencias() {
    }

    public TblReferencias(Integer pkidReferencia) {
        this.pkidReferencia = pkidReferencia;
    }

    public Integer getPkidReferencia() {
        return pkidReferencia;
    }

    public void setPkidReferencia(Integer pkidReferencia) {
        this.pkidReferencia = pkidReferencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<TblPaciente> getTblPacienteCollection() {
        return tblPacienteCollection;
    }

    public void setTblPacienteCollection(Collection<TblPaciente> tblPacienteCollection) {
        this.tblPacienteCollection = tblPacienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidReferencia != null ? pkidReferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblReferencias)) {
            return false;
        }
        TblReferencias other = (TblReferencias) object;
        if ((this.pkidReferencia == null && other.pkidReferencia != null) || (this.pkidReferencia != null && !this.pkidReferencia.equals(other.pkidReferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vista.TblReferencias[ pkidReferencia=" + pkidReferencia + " ]";
    }
    
}
