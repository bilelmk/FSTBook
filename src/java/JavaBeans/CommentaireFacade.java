/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

import entities.Commentaire;
import entities.Publication;
import java.util.Vector;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author SADOK
 */
@Stateless
public class CommentaireFacade extends AbstractFacade<Commentaire> {

    @PersistenceContext(unitName = "Tp8PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommentaireFacade() {
        super(Commentaire.class);
    }
    
    public Vector<Commentaire> findByIdPub(Publication pub) {
        Query query=em.createNamedQuery("Commentaire.findByIdPub", Commentaire.class);
        query.setParameter("idPub",pub);
        return  (Vector<Commentaire>) query.getResultList();
    }
}
