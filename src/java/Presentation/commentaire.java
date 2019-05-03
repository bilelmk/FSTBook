/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import JavaBeans.CommentaireFacade;
import entities.Commentaire;
import entities.Publication;
import entities.Utilisateur;
import java.util.Date;
import java.util.Vector;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author SADOK
 */
@Named(value = "commentaire")
@RequestScoped
public class commentaire {
    FacesContext context = FacesContext.getCurrentInstance();

    
    @EJB
    private CommentaireFacade commentairefacade ;
    private Utilisateur user;
    
    private Commentaire commentaire= new Commentaire();
    /**
     * Creates a new instance of commentaire
     */
    public commentaire() {
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Commentaire getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(Commentaire commentaire) {
        this.commentaire = commentaire;
    }
    
    public void addCommentaire(Publication pub){
        this.commentaire.setDate(new Date());
        this.commentaire.setIdPub(pub);
        this.commentaire.setIdUser(this.user);
        this.commentairefacade.create(this.commentaire);
    }
    
    public Vector<Commentaire> findCommentaire(Publication pub){
        return this.commentairefacade.findByIdPub(pub);
    }       
            
    
    @PostConstruct
    public void init() {
        this.user=  (Utilisateur) context.getExternalContext().getSessionMap().get("LoginUser");
    }
}
