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
@Table(name = "producto")
@NamedQueries({@NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")})
public class Producto implements Serializable {
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_producto")
  private Integer idProducto;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "descripcion")
  private String descripcion;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "estado")
  private boolean estado;
  
  public void setIdProducto(Integer idProducto) {
    this.idProducto = idProducto;
  }
  
  public void setDescripcion(@NotNull String descripcion) {
    this.descripcion = descripcion;
  }
  
  public void setEstado(@NotNull boolean estado) {
    this.estado = estado;
  }
  
  public Producto() {}
  
  public Integer getIdProducto() {
    return this.idProducto;
  }
  
  @NotNull
  public String getDescripcion() {
    return this.descripcion;
  }
  
  @NotNull
  public boolean isEstado() {
    return this.estado;
  }
  
  public Producto(Integer idProducto, String descripcion, boolean estado) {
    this.idProducto = idProducto;
    this.descripcion = descripcion;
    this.estado = estado;
  }
  
  public int hashCode() {
    int hash = 7;
    return hash;
  }
  
  public boolean equals(Object obj) {
    if (this == obj)
      return true; 
    if (obj == null)
      return false; 
    if (getClass() != obj.getClass())
      return false; 
    Producto other = (Producto)obj;
    if (this.estado != other.estado)
      return false; 
    if (!Objects.equals(this.descripcion, other.descripcion))
      return false; 
    return Objects.equals(this.idProducto, other.idProducto);
  }
  
  public String toString() {
    return "Producto{idProducto=" + this.idProducto + ", descripcion=" + this.descripcion + ", estado=" + this.estado + '}';
  }
}