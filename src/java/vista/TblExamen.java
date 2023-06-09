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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author niels
 */
@Entity
@Table(name = "tbl_examen")
@NamedQueries({
    @NamedQuery(name = "TblExamen.findAll", query = "SELECT t FROM TblExamen t"),
    @NamedQuery(name = "TblExamen.findByPkidExamen", query = "SELECT t FROM TblExamen t WHERE t.pkidExamen = :pkidExamen"),
    @NamedQuery(name = "TblExamen.findByNombreExam", query = "SELECT t FROM TblExamen t WHERE t.nombreExam = :nombreExam"),
    @NamedQuery(name = "TblExamen.findByPrecio", query = "SELECT t FROM TblExamen t WHERE t.precio = :precio")})
public class TblExamen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pk_idExamen")
    private Integer pkidExamen;
    @Column(name = "nombreExam")
    private String nombreExam;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Double precio;
    @JoinColumn(name = "fk_codtipoExam", referencedColumnName = "pk_codtipoExam")
    @ManyToOne
    private TblTipoexamen fkcodtipoExam;
    @OneToMany(mappedBy = "fkidExamen")
    private Collection<TblDetallefactura> tblDetallefacturaCollection;

    public TblExamen() {
    }

    public TblExamen(Integer pkidExamen) {
        this.pkidExamen = pkidExamen;
    }

    public Integer getPkidExamen() {
        return pkidExamen;
    }

    public void setPkidExamen(Integer pkidExamen) {
        this.pkidExamen = pkidExamen;
    }

    public String getNombreExam() {
        return nombreExam;
    }

    public void setNombreExam(String nombreExam) {
        this.nombreExam = nombreExam;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public TblTipoexamen getFkcodtipoExam() {
        return fkcodtipoExam;
    }

    public void setFkcodtipoExam(TblTipoexamen fkcodtipoExam) {
        this.fkcodtipoExam = fkcodtipoExam;
    }

    public Collection<TblDetallefactura> getTblDetallefacturaCollection() {
        return tblDetallefacturaCollection;
    }

    public void setTblDetallefacturaCollection(Collection<TblDetallefactura> tblDetallefacturaCollection) {
        this.tblDetallefacturaCollection = tblDetallefacturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidExamen != null ? pkidExamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblExamen)) {
            return false;
        }
        TblExamen other = (TblExamen) object;
        if ((this.pkidExamen == null && other.pkidExamen != null) || (this.pkidExamen != null && !this.pkidExamen.equals(other.pkidExamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vista.TblExamen[ pkidExamen=" + pkidExamen + " ]";
    }
    
}
