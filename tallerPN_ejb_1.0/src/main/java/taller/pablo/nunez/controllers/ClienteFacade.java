package taller.pablo.nunez.controllers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import taller.pablo.nunez.entities.Cliente;

@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {
    
    @PersistenceContext(unitName = "tallerPnPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return this.em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
}
