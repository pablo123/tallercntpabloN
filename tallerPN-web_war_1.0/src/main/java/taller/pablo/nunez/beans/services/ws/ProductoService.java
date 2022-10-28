/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package taller.pablo.nunez.beans.services.ws;


import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import taller.pablo.nunez.controllers.ProductoFacade;
import taller.pablo.nunez.entities.Producto;

/**
 * Servicio Web con SOAP para administrar las operaciones de tipo de paciente
 *
 * @author martosfre
 */
@WebService(serviceName = "wsproducto")
public class ProductoService {

    
    @Inject
    private ProductoFacade adminProducto;

    /**
     * This is a sample web service operation
     *
     * @param id ID del paciente
     * @return Paciente
     */
    @WebMethod(operationName = "consultarProductoPorId")
    public Producto consultarPorId(@WebParam(name = "id") Integer id) {
        return adminProducto.buscarPorId(id);
    }

    @WebMethod(operationName = "consultarTodos")
    public List<Producto> consultarTodos() {
        return adminProducto.buscarTodos();
    }

    /**
     * Método para guardar un tipo de tipoPaciente
     *
     * @param producto
     * @return
     */
    public String guardarVendedor(Producto producto) {
        try {
                adminProducto.guardar(producto);
                return "Producto registrado correctamente";
            
        } catch (Exception e) {
            return "Error al Guardar:" + e.getMessage();
        }
    }

    /**
     * Método para actualizar el tipo de tipoPaciente
     *
     * @param producto tipo de paciente que existe en la bdd
     * @return mensaje de confirmación
     */
    @WebMethod(operationName = "actualizarProducto")
    public String actualizarProducto(Producto producto) {
        try {
            if (adminProducto.buscarPorId(producto.getIdProducto()) != null) {
                adminProducto.actualizar(producto);
                return "Tipo Paciente actualizado correctamente";
            } else {
                return "Tipo de Paciente no existe";
            }

        } catch (Exception e) {
            return "Error al Actualizar:" + e.getMessage();
        }
    }

    /**
     * Método para eliminar el tipo de paciente
     *
     * @param idProducto identificador de tipo de paciente
     * @return mensaje de confirmación
     */
    public String eliminarProducto(@WebParam(name = "idProducto") int idProducto) {
        try {
            Producto producto = adminProducto.buscarPorId(idProducto);
            if (producto != null) {
                adminProducto.eliminar(producto);
                return "Producto eliminado correctamente";
            } else {
                return "Producto no existe";
            }

        } catch (Exception e) {
            return "Error al Eliminar:" + e.getMessage();
        }
    }
}
