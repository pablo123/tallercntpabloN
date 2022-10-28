/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller.pablo.nunez.converters;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import taller.pablo.nunez.controllers.AbstractFacade;
import taller.pablo.nunez.controllers.ClienteFacade;
import taller.pablo.nunez.entities.Cliente;

/**
 *
 * @author martosfre
 */
@Named("convCliente") //Soporte la @Inject
@RequestScoped
public class ConvCliente extends ConvGenerico<Cliente> {

    @Inject
    private ClienteFacade adminEspecialidad;

    @Override
    protected AbstractFacade<Cliente> getAdminGenerico() {
       return adminEspecialidad;
    }

}
