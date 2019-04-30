/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

import entities.Forum;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Y520
 */
@Stateless
public class ForumFacade extends AbstractFacade<Forum> {
    @PersistenceContext(unitName = "Tp8PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ForumFacade() {
        super(Forum.class);
    }
    
    public Forum findByid(int id) {
          Query query=em.createNamedQuery("Forum.findById", Forum.class);
          query.setParameter("idForum",id);
          return  (Forum) query.getSingleResult();
      }   
}
