/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller.pablo.nunez.beans;

import taller.pablo.nunez.beans.util.AbstractManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import taller.pablo.nunez.controllers.ClienteFacade;
import taller.pablo.nunez.controllers.ProductoFacade;
import taller.pablo.nunez.controllers.VentasFacade;
import taller.pablo.nunez.entities.Cliente;
import taller.pablo.nunez.entities.Producto;
import taller.pablo.nunez.entities.Ventas;

/**
 *
 * @author martosfre
 */
@Named
@ViewScoped
public class VentasBean extends AbstractManagedBean implements Serializable {

    @Getter @Setter
    private Ventas venta;
    
    @Getter @Setter
    private List<Ventas> lstVentas;
    
    @Getter @Setter
    private List<Cliente> lstClientes;
    
    @Getter @Setter
    private List<Producto> lstProductos;

    @Getter @Setter
    private String direccion;
    
    boolean editar;
    
    @Inject
    private VentasFacade adminVentas;
    @Inject
    private ClienteFacade adminCliente;
    @Inject
    private ProductoFacade adminProducto;

    public VentasBean() {
        this.venta = new Ventas();
        this.lstClientes = new ArrayList<>();
        this.lstProductos = new ArrayList<>();
    }

    public void prepararNuevo(){
        this.venta = new Ventas();
        this.editar = false;
    }
    
    public void prepararEditar(Ventas venta){
        this.venta = venta;
    }
    
    public void eliminar(Ventas venta){
        
    }
    
    public void guardar(){
        
        if(editar)
            adminVentas.actualizar(this.venta);
        else
            adminVentas.guardar(this.venta);
        
    }
    

    @PostConstruct
    public void inicializar() {
        this.lstVentas = adminVentas.buscarTodos();
        this.lstClientes = adminCliente.buscarTodos();
        this.lstProductos = adminProducto.buscarTodos();
        
    }

}
