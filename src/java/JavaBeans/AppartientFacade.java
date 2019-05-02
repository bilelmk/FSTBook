/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

import entities.Appartient;
import entities.Utilisateur;
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
public class AppartientFacade extends AbstractFacade<Appartient> {

    @PersistenceContext(unitName = "Tp8PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AppartientFacade() {
        super(Appartient.class);
    }
    public Vector<Appartient> findByIdUser(Utilisateur userId) {
        Query query=em.createNamedQuery("Appartient.findByIdUser", Appartient.class);
        query.setParameter("idUser",userId);
        return   (Vector<Appartient>) query.getResultList();
    }

    
}
