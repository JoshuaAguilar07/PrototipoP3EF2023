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
@Table(name = "tbl_pago")
@NamedQueries({
    @NamedQuery(name = "TblPago.findAll", query = "SELECT t FROM TblPago t"),
    @NamedQuery(name = "TblPago.findByPkidPago", query = "SELECT t FROM TblPago t WHERE t.pkidPago = :pkidPago"),
    @NamedQuery(name = "TblPago.findByTipoPago", query = "SELECT t FROM TblPago t WHERE t.tipoPago = :tipoPago")})
public class TblPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pk_idPago")
    private Integer pkidPago;
    @Column(name = "tipoPago")
    private String tipoPago;
    @OneToMany(mappedBy = "fkidTipoPago")
    private Collection<TblEncabezadofactura> tblEncabezadofacturaCollection;

    public TblPago() {
    }

    public TblPago(Integer pkidPago) {
        this.pkidPago = pkidPago;
    }

    public Integer getPkidPago() {
        return pkidPago;
    }

    public void setPkidPago(Integer pkidPago) {
        this.pkidPago = pkidPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
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
        hash += (pkidPago != null ? pkidPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPago)) {
            return false;
        }
        TblPago other = (TblPago) object;
        if ((this.pkidPago == null && other.pkidPago != null) || (this.pkidPago != null && !this.pkidPago.equals(other.pkidPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vista.TblPago[ pkidPago=" + pkidPago + " ]";
    }
    
}
