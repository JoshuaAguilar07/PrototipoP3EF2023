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
@Table(name = "tbl_movBitacora")
@NamedQueries({
    @NamedQuery(name = "TblmovBitacora.findAll", query = "SELECT t FROM TblmovBitacora t"),
    @NamedQuery(name = "TblmovBitacora.findByPkRegistro", query = "SELECT t FROM TblmovBitacora t WHERE t.pkRegistro = :pkRegistro")})
public class TblmovBitacora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pk_Registro")
    private Integer pkRegistro;
    @JoinColumn(name = "fk_RegistroB", referencedColumnName = "pk_RegistroB")
    @ManyToOne(optional = false)
    private TblBitacora fkRegistroB;
    @JoinColumn(name = "fk_idEncabezado", referencedColumnName = "pk_idEncabezado")
    @ManyToOne
    private TblEncabezadofactura fkidEncabezado;

    public TblmovBitacora() {
    }

    public TblmovBitacora(Integer pkRegistro) {
        this.pkRegistro = pkRegistro;
    }

    public Integer getPkRegistro() {
        return pkRegistro;
    }

    public void setPkRegistro(Integer pkRegistro) {
        this.pkRegistro = pkRegistro;
    }

    public TblBitacora getFkRegistroB() {
        return fkRegistroB;
    }

    public void setFkRegistroB(TblBitacora fkRegistroB) {
        this.fkRegistroB = fkRegistroB;
    }

    public TblEncabezadofactura getFkidEncabezado() {
        return fkidEncabezado;
    }

    public void setFkidEncabezado(TblEncabezadofactura fkidEncabezado) {
        this.fkidEncabezado = fkidEncabezado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkRegistro != null ? pkRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblmovBitacora)) {
            return false;
        }
        TblmovBitacora other = (TblmovBitacora) object;
        if ((this.pkRegistro == null && other.pkRegistro != null) || (this.pkRegistro != null && !this.pkRegistro.equals(other.pkRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vista.TblmovBitacora[ pkRegistro=" + pkRegistro + " ]";
    }
    
}
