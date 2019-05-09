/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.antoniomanuelramirez.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antonio Manuel
 */
@Entity
@Table(name = "PILOTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pilotos.findAll", query = "SELECT p FROM Pilotos p")
    , @NamedQuery(name = "Pilotos.findById", query = "SELECT p FROM Pilotos p WHERE p.id = :id")
    , @NamedQuery(name = "Pilotos.findByNombre", query = "SELECT p FROM Pilotos p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Pilotos.findByApellidos", query = "SELECT p FROM Pilotos p WHERE p.apellidos = :apellidos")
    , @NamedQuery(name = "Pilotos.findByDni", query = "SELECT p FROM Pilotos p WHERE p.dni = :dni")
    , @NamedQuery(name = "Pilotos.findByNumtelefono", query = "SELECT p FROM Pilotos p WHERE p.numtelefono = :numtelefono")
    , @NamedQuery(name = "Pilotos.findByFecnacimiento", query = "SELECT p FROM Pilotos p WHERE p.fecnacimiento = :fecnacimiento")
    , @NamedQuery(name = "Pilotos.findByFoto", query = "SELECT p FROM Pilotos p WHERE p.foto = :foto")
    , @NamedQuery(name = "Pilotos.findBySalario", query = "SELECT p FROM Pilotos p WHERE p.salario = :salario")
    , @NamedQuery(name = "Pilotos.findByCategoria", query = "SELECT p FROM Pilotos p WHERE p.categoria = :categoria")})
public class Pilotos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "DNI")
    private String dni;
    @Column(name = "NUMTELEFONO")
    private String numtelefono;
    @Basic(optional = false)
    @Column(name = "FECNACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fecnacimiento;
    @Basic(optional = false)
    @Column(name = "FOTO")
    private String foto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARIO")
    private BigDecimal salario;
    @Basic(optional = false)
    @Column(name = "CATEGORIA")
    private String categoria;
    @JoinColumn(name = "EQUIPO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Equipo equipo;

    public Pilotos() {
    }

    public Pilotos(Integer id) {
        this.id = id;
    }

    public Pilotos(Integer id, String nombre, String apellidos, String dni, Date fecnacimiento, String foto, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fecnacimiento = fecnacimiento;
        this.foto = foto;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNumtelefono() {
        return numtelefono;
    }

    public void setNumtelefono(String numtelefono) {
        this.numtelefono = numtelefono;
    }

    public Date getFecnacimiento() {
        return fecnacimiento;
    }

    public void setFecnacimiento(Date fecnacimiento) {
        this.fecnacimiento = fecnacimiento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pilotos)) {
            return false;
        }
        Pilotos other = (Pilotos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.antoniomanuelramirez.entities.Pilotos[ id=" + id + " ]";
    }
    
}
