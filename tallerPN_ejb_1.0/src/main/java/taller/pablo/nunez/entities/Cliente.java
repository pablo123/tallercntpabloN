
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
@Table(name = "cliente")
@NamedQueries({@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")})
public class Cliente implements Serializable {
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_cliente")
  private Integer idCliente;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "nombre")
  private String nombre;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "apellido")
  private String apellido;
  
  public void setIdCliente(Integer idCliente) {
    this.idCliente = idCliente;
  }
  
  public void setNombre(@NotNull String nombre) {
    this.nombre = nombre;
  }
  
  public void setApellido(@NotNull String apellido) {
    this.apellido = apellido;
  }
  
  public Cliente() {}
  
  public Integer getIdCliente() {
    return this.idCliente;
  }
  
  @NotNull
  public String getNombre() {
    return this.nombre;
  }
  
  @NotNull
  public String getApellido() {
    return this.apellido;
  }
  
  public Cliente(Integer idCliente, String nombre, String apellido) {
    this.idCliente = idCliente;
    this.nombre = nombre;
    this.apellido = apellido;
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
    Cliente other = (Cliente)obj;
    if (!Objects.equals(this.nombre, other.nombre))
      return false; 
    if (!Objects.equals(this.apellido, other.apellido))
      return false; 
    return Objects.equals(this.idCliente, other.idCliente);
  }
  
  public String toString() {
    return "ClienteTienda{idCliente=" + this.idCliente + ", nombre=" + this.nombre + ", apellido=" + this.apellido + '}';
  }
}
