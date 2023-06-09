/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author niels
 */
@Entity
@Table(name = "tbl_detallefactura")
@NamedQueries({
    @NamedQuery(name = "TblDetallefactura.findAll", query = "SELECT t FROM TblDetallefactura t"),
    @NamedQuery(name = "TblDetallefactura.findByPkidDetallefac", query = "SELECT t FROM TblDetallefactura t WHERE t.pkidDetallefac = :pkidDetallefac"),
    @NamedQuery(name = "TblDetallefactura.findBySubtotal", query = "SELECT t FROM TblDetallefactura t WHERE t.subtotal = :subtotal")})
public class TblDetallefactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pk_idDetallefac")
    private Integer pkidDetallefac;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "subtotal")
    private Double subtotal;
    @JoinColumn(name = "fk_idEncabezado", referencedColumnName = "pk_idEncabezado")
    @ManyToOne
    private TblEncabezadofactura fkidEncabezado;
    @JoinColumn(name = "fk_idExamen", referencedColumnName = "pk_idExamen")
    @ManyToOne
    private TblExamen fkidExamen;

    public TblDetallefactura() {
    }

    public TblDetallefactura(Integer pkidDetallefac) {
        this.pkidDetallefac = pkidDetallefac;
    }

    public Integer getPkidDetallefac() {
        return pkidDetallefac;
    }

    public void setPkidDetallefac(Integer pkidDetallefac) {
        this.pkidDetallefac = pkidDetallefac;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public TblEncabezadofactura getFkidEncabezado() {
        return fkidEncabezado;
    }

    public void setFkidEncabezado(TblEncabezadofactura fkidEncabezado) {
        this.fkidEncabezado = fkidEncabezado;
    }

    public TblExamen getFkidExamen() {
        return fkidExamen;
    }

    public void setFkidExamen(TblExamen fkidExamen) {
        this.fkidExamen = fkidExamen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidDetallefac != null ? pkidDetallefac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetallefactura)) {
            return false;
        }
        TblDetallefactura other = (TblDetallefactura) object;
        if ((this.pkidDetallefac == null && other.pkidDetallefac != null) || (this.pkidDetallefac != null && !this.pkidDetallefac.equals(other.pkidDetallefac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vista.TblDetallefactura[ pkidDetallefac=" + pkidDetallefac + " ]";
    }
    
}
