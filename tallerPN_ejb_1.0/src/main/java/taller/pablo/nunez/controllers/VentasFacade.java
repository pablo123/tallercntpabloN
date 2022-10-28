package taller.pablo.nunez.controllers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import taller.pablo.nunez.entities.Ventas;

@Stateless
public class VentasFacade extends AbstractFacade<Ventas> {
    @PersistenceContext(unitName = "tallerPnPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return this.em;
    }

    public VentasFacade() {
        super(Ventas.class);
    }
}
