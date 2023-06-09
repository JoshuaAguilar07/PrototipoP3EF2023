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
@Table(name = "tbl_login")
@NamedQueries({
    @NamedQuery(name = "TblLogin.findAll", query = "SELECT t FROM TblLogin t"),
    @NamedQuery(name = "TblLogin.findByPkidUser", query = "SELECT t FROM TblLogin t WHERE t.pkidUser = :pkidUser"),
    @NamedQuery(name = "TblLogin.findByUsuario", query = "SELECT t FROM TblLogin t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "TblLogin.findByContrase\u00f1a", query = "SELECT t FROM TblLogin t WHERE t.contrase\u00f1a = :contrase\u00f1a"),
    @NamedQuery(name = "TblLogin.findByEstado", query = "SELECT t FROM TblLogin t WHERE t.estado = :estado")})
public class TblLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pk_idUser")
    private Integer pkidUser;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    @Column(name = "estado")
    private Integer estado;
    @OneToMany(mappedBy = "fkidUser")
    private Collection<TblBitacora> tblBitacoraCollection;
    @OneToMany(mappedBy = "fkidUser")
    private Collection<TblEmpleados> tblEmpleadosCollection;

    public TblLogin() {
    }

    public TblLogin(Integer pkidUser) {
        this.pkidUser = pkidUser;
    }

    public Integer getPkidUser() {
        return pkidUser;
    }

    public void setPkidUser(Integer pkidUser) {
        this.pkidUser = pkidUser;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Collection<TblBitacora> getTblBitacoraCollection() {
        return tblBitacoraCollection;
    }

    public void setTblBitacoraCollection(Collection<TblBitacora> tblBitacoraCollection) {
        this.tblBitacoraCollection = tblBitacoraCollection;
    }

    public Collection<TblEmpleados> getTblEmpleadosCollection() {
        return tblEmpleadosCollection;
    }

    public void setTblEmpleadosCollection(Collection<TblEmpleados> tblEmpleadosCollection) {
        this.tblEmpleadosCollection = tblEmpleadosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidUser != null ? pkidUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblLogin)) {
            return false;
        }
        TblLogin other = (TblLogin) object;
        if ((this.pkidUser == null && other.pkidUser != null) || (this.pkidUser != null && !this.pkidUser.equals(other.pkidUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vista.TblLogin[ pkidUser=" + pkidUser + " ]";
    }
    
}
