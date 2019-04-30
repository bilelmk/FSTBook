/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import JavaBeans.ForumFacade;
import JavaBeans.PublicationFacade;
import entities.Forum;
import entities.Publication;
import entities.Utilisateur;
import java.util.List;
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
@Named(value = "forms")
@RequestScoped
public class FormsView {
    
    FacesContext context = FacesContext.getCurrentInstance();
    @EJB
    private ForumFacade forumfacade ;
    @EJB
    private PublicationFacade pubfacade ;
    private Utilisateur user;
    private Vector<Forum> formList;
    private Vector<Publication> publicationList;

    public Vector<Forum> getFormList() {
        return formList;
    }

    public void setFormList(Vector<Forum> formList) {
        this.formList = formList;
    }

    
    
    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Vector<Publication> getPublicationList() {
        return publicationList;
    }

    public void setPublicationList(Vector<Publication> publicationList) {
        this.publicationList = publicationList;
    }
    
    
    /**
     * Creates a new instance of Forms
     */
    public FormsView() {
    }
    
    public Vector<Forum> listForum(){
        try{
            this.user=  (Utilisateur) context.getExternalContext().getSessionMap().get("LoginUser");
            return this.forumfacade.findByIdUser(this.user);
            }
       catch(Exception e){
           
        } 
        return null;
    }

    public void showPub(Forum idForum){
        try{
            System.out.println("hahah");
            this.publicationList = this.pubfacade.findByIdForum(idForum);
            System.out.println(this.publicationList);
            }
       catch(Exception e){
           
        } 
        
    }
    
    @PostConstruct
    public void init() {
        this.formList= this.listForum();
        this.publicationList= new Vector<Publication>() ;
        
    }
}
