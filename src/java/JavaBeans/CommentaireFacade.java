/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

import entities.Commentaire;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Y520
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
    
}
