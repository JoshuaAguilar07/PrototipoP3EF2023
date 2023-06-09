/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author niels
 */
@Entity
@Table(name = "tbl_empleados")
@NamedQueries({
    @NamedQuery(name = "TblEmpleados.findAll", query = "SELECT t FROM TblEmpleados t"),
    @NamedQuery(name = "TblEmpleados.findByPkidEmpleado", query = "SELECT t FROM TblEmpleados t WHERE t.pkidEmpleado = :pkidEmpleado"),
    @NamedQuery(name = "TblEmpleados.findByNombre", query = "SELECT t FROM TblEmpleados t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TblEmpleados.findByApellido", query = "SELECT t FROM TblEmpleados t WHERE t.apellido = :apellido"),
    @NamedQuery(name = "TblEmpleados.findByTelefono", query = "SELECT t FROM TblEmpleados t WHERE t.telefono = :telefono"),
    @NamedQuery(name = "TblEmpleados.findByDpi", query = "SELECT t FROM TblEmpleados t WHERE t.dpi = :dpi"),
    @NamedQuery(name = "TblEmpleados.findByDireccion", query = "SELECT t FROM TblEmpleados t WHERE t.direccion = :direccion"),
    @NamedQuery(name = "TblEmpleados.findByFechaNacimiento", query = "SELECT t FROM TblEmpleados t WHERE t.fechaNacimiento = :fechaNacimiento")})
public class TblEmpleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pk_idEmpleado")
    private Integer pkidEmpleado;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Telefono")
    private Integer telefono;
    @Column(name = "DPI")
    private Integer dpi;
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "FechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @JoinColumn(name = "fk_idUser", referencedColumnName = "pk_idUser")
    @ManyToOne
    private TblLogin fkidUser;

    public TblEmpleados() {
    }

    public TblEmpleados(Integer pkidEmpleado) {
        this.pkidEmpleado = pkidEmpleado;
    }

    public Integer getPkidEmpleado() {
        return pkidEmpleado;
    }

    public void setPkidEmpleado(Integer pkidEmpleado) {
        this.pkidEmpleado = pkidEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getDpi() {
        return dpi;
    }

    public void setDpi(Integer dpi) {
        this.dpi = dpi;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public TblLogin getFkidUser() {
        return fkidUser;
    }

    public void setFkidUser(TblLogin fkidUser) {
        this.fkidUser = fkidUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidEmpleado != null ? pkidEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEmpleados)) {
            return false;
        }
        TblEmpleados other = (TblEmpleados) object;
        if ((this.pkidEmpleado == null && other.pkidEmpleado != null) || (this.pkidEmpleado != null && !this.pkidEmpleado.equals(other.pkidEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vista.TblEmpleados[ pkidEmpleado=" + pkidEmpleado + " ]";
    }
    
}
