/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller.pablo.nunez.converters;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import taller.pablo.nunez.controllers.AbstractFacade;
import taller.pablo.nunez.controllers.ProductoFacade;
import taller.pablo.nunez.entities.Producto;

/**
 *
 * @author martosfre
 */
@Named("convProducto") //Soporte la @Inject
@RequestScoped
public class ConvProducto extends ConvGenerico<Producto> {

    @Inject
    private ProductoFacade adminPaciente;

    @Override
    protected AbstractFacade<Producto> getAdminGenerico() {
       return adminPaciente;
    }

}
