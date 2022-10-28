package taller.pablo.nunez.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "vendedor")
@NamedQueries({@NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v")})
public class Vendedor implements Serializable {
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_vendedor")
  private Integer idVendedor;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "nombre")
  private String nombre;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "apellido")
  private String apellido;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "estado")
  private boolean estado;
  
  public void setIdVendedor(Integer idVendedor) {
    this.idVendedor = idVendedor;
  }
  
  public void setNombre(@NotNull String nombre) {
    this.nombre = nombre;
  }
  
  public void setApellido(@NotNull String apellido) {
    this.apellido = apellido;
  }
  
  public void setEstado(@NotNull boolean estado) {
    this.estado = estado;
  }
  
  public Vendedor() {}
  
  public Integer getIdVendedor() {
    return this.idVendedor;
  }
  
  @NotNull
  public String getNombre() {
    return this.nombre;
  }
  
  @NotNull
  public String getApellido() {
    return this.apellido;
  }
  
  @NotNull
  public boolean isEstado() {
    return this.estado;
  }
  
  public Vendedor(Integer idVendedor, String nombre, String apellido, boolean estado) {
    this.idVendedor = idVendedor;
    this.nombre = nombre;
    this.apellido = apellido;
    this.estado = estado;
  }
  
  public int hashCode() {
    int hash = 3;
    return hash;
  }
  
  public boolean equals(Object obj) {
    if (this == obj)
      return true; 
    if (obj == null)
      return false; 
    if (getClass() != obj.getClass())
      return false; 
    Vendedor other = (Vendedor)obj;
    if (this.estado != other.estado)
      return false; 
    if (!Objects.equals(this.nombre, other.nombre))
      return false; 
    if (!Objects.equals(this.apellido, other.apellido))
      return false; 
    return Objects.equals(this.idVendedor, other.idVendedor);
  }
  
  public String toString() {
    return "Vendedor{idVendedor=" + this.idVendedor + ", nombre=" + this.nombre + ", apellido=" + this.apellido + ", estado=" + this.estado + '}';
  }
}
