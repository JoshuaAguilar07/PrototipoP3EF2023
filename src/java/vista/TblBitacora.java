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
import javax.persistence.CascadeType;
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
@Table(name = "tbl_bitacora")
@NamedQueries({
    @NamedQuery(name = "TblBitacora.findAll", query = "SELECT t FROM TblBitacora t"),
    @NamedQuery(name = "TblBitacora.findByPkRegistroB", query = "SELECT t FROM TblBitacora t WHERE t.pkRegistroB = :pkRegistroB"),
    @NamedQuery(name = "TblBitacora.findByRegIngreso", query = "SELECT t FROM TblBitacora t WHERE t.regIngreso = :regIngreso")})
public class TblBitacora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pk_RegistroB")
    private Integer pkRegistroB;
    @Column(name = "regIngreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regIngreso;
    @JoinColumn(name = "fk_idUser", referencedColumnName = "pk_idUser")
    @ManyToOne
    private TblLogin fkidUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkRegistroB")
    private Collection<TblmovBitacora> tblmovBitacoraCollection;

    public TblBitacora() {
    }

    public TblBitacora(Integer pkRegistroB) {
        this.pkRegistroB = pkRegistroB;
    }

    public Integer getPkRegistroB() {
        return pkRegistroB;
    }

    public void setPkRegistroB(Integer pkRegistroB) {
        this.pkRegistroB = pkRegistroB;
    }

    public Date getRegIngreso() {
        return regIngreso;
    }

    public void setRegIngreso(Date regIngreso) {
        this.regIngreso = regIngreso;
    }

    public TblLogin getFkidUser() {
        return fkidUser;
    }

    public void setFkidUser(TblLogin fkidUser) {
        this.fkidUser = fkidUser;
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
        hash += (pkRegistroB != null ? pkRegistroB.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblBitacora)) {
            return false;
        }
        TblBitacora other = (TblBitacora) object;
        if ((this.pkRegistroB == null && other.pkRegistroB != null) || (this.pkRegistroB != null && !this.pkRegistroB.equals(other.pkRegistroB))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vista.TblBitacora[ pkRegistroB=" + pkRegistroB + " ]";
    }
    
}
