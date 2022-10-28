package taller.pablo.nunez.controllers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import taller.pablo.nunez.entities.Vendedor;

@Stateless
public class VendedorFacade extends AbstractFacade<Vendedor> {
    
    @PersistenceContext(unitName = "tallerPnPU")
    private EntityManager em;
  
    protected EntityManager getEntityManager() {
        return this.em;
    }
  
    public VendedorFacade() {
        super(Vendedor.class);
    }
}
