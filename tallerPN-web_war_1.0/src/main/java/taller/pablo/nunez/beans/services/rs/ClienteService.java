/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller.pablo.nunez.beans.services.rs;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import taller.pablo.nunez.controllers.ClienteFacade;
import taller.pablo.nunez.entities.Cliente;

/**
 * Servicio Web para administrar las operaciones de Tipo de Paciente
 *
 * @author martosfre
 */
@Path("/cliente")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class ClienteService {

    @Context
    private HttpHeaders httpHeaders;

    @Inject
    private ClienteFacade adminCliente;

    @GET
    @Path("/{id}") //http;//localhost:8080/sysmed/api/tipoPaciente/1
    public Cliente consultarPorId(@PathParam(value = "id") int idCliente) {
        return adminCliente.buscarPorId(idCliente);
    }

    @GET
    @Path("/consultarTodos")//http;//localhost:8080/sysmed/api/tipoPaciente/consultarTodos
    public List<Cliente> consultarTodos() {
        return adminCliente.buscarTodos();
    }

    @POST //Guardar
    public String guardar(Cliente cliente) {
        String mensaje = null;
        try {
            MultivaluedMap<String, String> headers = httpHeaders.getRequestHeaders();
            if (headers.containsKey("usuario") && headers.containsKey("clave")) {
                if (headers.get("usuario").get(0).equals("admin")
                        && headers.get("clave").get(0).equals("1234")) {
                    adminCliente.guardar(cliente);
                    mensaje = "Tipo Paciente guardado correctamente";
                }
            } else {
                mensaje = "Usuario no autorizado";
            }
            return mensaje;

        } catch (Exception e) {
            return "Error al Guardar:" + e.getMessage();
        }
    }

    @PUT //Actualizar
    public String actualizar(Cliente cliente) {
        try {
            adminCliente.actualizar(cliente);
            return "Tipo Paciente actualizado correctamente";
        } catch (Exception e) {
            return "Error al Actualizar:" + e.getMessage();
        }
    }

    @DELETE//Eliminar
    @Path("/{id}")
    //@JWTTokenNeeded
    public String eliminar(@PathParam(value = "id") int idCliente) {
        try {
            Cliente tipoPaciente = adminCliente.buscarPorId(idCliente);
            adminCliente.eliminar(tipoPaciente);
            return "Tipo Paciente eliminado correctamente";
        } catch (Exception e) {
            return "Error al eliminar:" + e.getMessage();
        }
    }

}
