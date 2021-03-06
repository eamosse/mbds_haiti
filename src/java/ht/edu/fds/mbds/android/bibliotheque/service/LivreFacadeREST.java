/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.edu.fds.mbds.android.bibliotheque.service;

import ht.edu.fds.mbds.android.bibliotheque.Categorie;
import ht.edu.fds.mbds.android.bibliotheque.Livre;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author edou
 */
@Stateless
@Path("livre")
public class LivreFacadeREST extends AbstractFacade<Livre> {
    @EJB
    private CategorieFacadeREST categorieFacadeREST;
    @PersistenceContext(unitName = "WebBibliothequePU")
    private EntityManager em;

    public LivreFacadeREST() {
        super(Livre.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Livre entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Livre entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Livre find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Livre> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("findByCategory/{id}")
    @Produces({"application/xml", "application/json"})
    public List<Livre> findByCategory(@PathParam("id") Long id) {
        Categorie categorie = categorieFacadeREST.find(id);
        Query namedQuery = em.createNamedQuery("findByCategory");
        namedQuery.setParameter("categorie", categorie); 
        return namedQuery.getResultList();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Livre> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    
}
