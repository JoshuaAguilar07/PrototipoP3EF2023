/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "tbl_tipoexamen")
@NamedQueries({
    @NamedQuery(name = "TblTipoexamen.findAll", query = "SELECT t FROM TblTipoexamen t"),
    @NamedQuery(name = "TblTipoexamen.findByPkcodtipoExam", query = "SELECT t FROM TblTipoexamen t WHERE t.pkcodtipoExam = :pkcodtipoExam"),
    @NamedQuery(name = "TblTipoexamen.findByNomtipExam", query = "SELECT t FROM TblTipoexamen t WHERE t.nomtipExam = :nomtipExam"),
    @NamedQuery(name = "TblTipoexamen.findByDescripcion", query = "SELECT t FROM TblTipoexamen t WHERE t.descripcion = :descripcion")})
public class TblTipoexamen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pk_codtipoExam")
    private Integer pkcodtipoExam;
    @Column(name = "nom_tipExam")
    private String nomtipExam;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "fkcodtipoExam")
    private Collection<TblExamen> tblExamenCollection;

    public TblTipoexamen() {
    }

    public TblTipoexamen(Integer pkcodtipoExam) {
        this.pkcodtipoExam = pkcodtipoExam;
    }

    public Integer getPkcodtipoExam() {
        return pkcodtipoExam;
    }

    public void setPkcodtipoExam(Integer pkcodtipoExam) {
        this.pkcodtipoExam = pkcodtipoExam;
    }

    public String getNomtipExam() {
        return nomtipExam;
    }

    public void setNomtipExam(String nomtipExam) {
        this.nomtipExam = nomtipExam;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<TblExamen> getTblExamenCollection() {
        return tblExamenCollection;
    }

    public void setTblExamenCollection(Collection<TblExamen> tblExamenCollection) {
        this.tblExamenCollection = tblExamenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkcodtipoExam != null ? pkcodtipoExam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTipoexamen)) {
            return false;
        }
        TblTipoexamen other = (TblTipoexamen) object;
        if ((this.pkcodtipoExam == null && other.pkcodtipoExam != null) || (this.pkcodtipoExam != null && !this.pkcodtipoExam.equals(other.pkcodtipoExam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vista.TblTipoexamen[ pkcodtipoExam=" + pkcodtipoExam + " ]";
    }
    
}
