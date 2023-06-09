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
@Table(name = "tbl_encabezadofactura")
@NamedQueries({
    @NamedQuery(name = "TblEncabezadofactura.findAll", query = "SELECT t FROM TblEncabezadofactura t"),
    @NamedQuery(name = "TblEncabezadofactura.findByPkidEncabezado", query = "SELECT t FROM TblEncabezadofactura t WHERE t.pkidEncabezado = :pkidEncabezado"),
    @NamedQuery(name = "TblEncabezadofactura.findBySerieFactura", query = "SELECT t FROM TblEncabezadofactura t WHERE t.serieFactura = :serieFactura"),
    @NamedQuery(name = "TblEncabezadofactura.findByNumFactura", query = "SELECT t FROM TblEncabezadofactura t WHERE t.numFactura = :numFactura"),
    @NamedQuery(name = "TblEncabezadofactura.findByFechaOrden", query = "SELECT t FROM TblEncabezadofactura t WHERE t.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "TblEncabezadofactura.findByTotal", query = "SELECT t FROM TblEncabezadofactura t WHERE t.total = :total")})
public class TblEncabezadofactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pk_idEncabezado")
    private Integer pkidEncabezado;
    @Column(name = "serieFactura")
    private String serieFactura;
    @Column(name = "numFactura")
    private Integer numFactura;
    @Column(name = "fechaOrden")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOrden;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;
    @OneToMany(mappedBy = "fkidEncabezado")
    private Collection<TblDetallefactura> tblDetallefacturaCollection;
    @JoinColumn(name = "fk_idPaciente", referencedColumnName = "pk_idPaciente")
    @ManyToOne
    private TblPaciente fkidPaciente;
    @JoinColumn(name = "fk_idTipoPago", referencedColumnName = "pk_idPago")
    @ManyToOne
    private TblPago fkidTipoPago;
    @OneToMany(mappedBy = "fkidEncabezado")
    private Collection<TblmovBitacora> tblmovBitacoraCollection;

    public TblEncabezadofactura() {
    }

    public TblEncabezadofactura(Integer pkidEncabezado) {
        this.pkidEncabezado = pkidEncabezado;
    }

    public Integer getPkidEncabezado() {
        return pkidEncabezado;
    }

    public void setPkidEncabezado(Integer pkidEncabezado) {
        this.pkidEncabezado = pkidEncabezado;
    }

    public String getSerieFactura() {
        return serieFactura;
    }

    public void setSerieFactura(String serieFactura) {
        this.serieFactura = serieFactura;
    }

    public Integer getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(Integer numFactura) {
        this.numFactura = numFactura;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Collection<TblDetallefactura> getTblDetallefacturaCollection() {
        return tblDetallefacturaCollection;
    }

    public void setTblDetallefacturaCollection(Collection<TblDetallefactura> tblDetallefacturaCollection) {
        this.tblDetallefacturaCollection = tblDetallefacturaCollection;
    }

    public TblPaciente getFkidPaciente() {
        return fkidPaciente;
    }

    public void setFkidPaciente(TblPaciente fkidPaciente) {
        this.fkidPaciente = fkidPaciente;
    }

    public TblPago getFkidTipoPago() {
        return fkidTipoPago;
    }

    public void setFkidTipoPago(TblPago fkidTipoPago) {
        this.fkidTipoPago = fkidTipoPago;
    }

    public Collection<TblmovBitacora> getTblmovBitacoraCollection() {
        return tblmovBitacoraCollection;
    }

    public void setTblmovBitacoraCollection(Collection<TblmovBitacora> tblmovBitacoraCollection) {
        this.tblmovBitacoraCollection = tblmovBitacoraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidEncabezado != null ? pkidEncabezado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEncabezadofactura)) {
            return false;
        }
        TblEncabezadofactura other = (TblEncabezadofactura) object;
        if ((this.pkidEncabezado == null && other.pkidEncabezado != null) || (this.pkidEncabezado != null && !this.pkidEncabezado.equals(other.pkidEncabezado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vista.TblEncabezadofactura[ pkidEncabezado=" + pkidEncabezado + " ]";
    }
    
}
