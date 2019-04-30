/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

import entities.Forum;
import entities.Publication;
import java.util.ArrayList;
import java.util.Vector;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Y520
 */
@Stateless
public class PublicationFacade extends AbstractFacade<Publication> {
    @PersistenceContext(unitName = "Tp8PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PublicationFacade() {
        super(Publication.class);
    }
    
    public Vector<Publication> findByIdForum(Forum id) {
        Query query=em.createNamedQuery("Publication.idForum", Publication.class);
        query.setParameter("id",id);
        return  (Vector<Publication>) query.getResultList();
    }

   
    
}
