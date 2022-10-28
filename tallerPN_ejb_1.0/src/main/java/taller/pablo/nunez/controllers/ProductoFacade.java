package taller.pablo.nunez.controllers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import taller.pablo.nunez.entities.Producto;

@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {
    @PersistenceContext(unitName = "tallerPnPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return this.em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
}
