/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import JavaBeans.AppartientFacade;
import JavaBeans.ForumFacade;
import JavaBeans.PublicationFacade;
import entities.Appartient;
import entities.Forum;
import entities.Publication;
import entities.Utilisateur;
import java.util.Date;
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
    @EJB
    private AppartientFacade apprtientfacade ;
    private Utilisateur user;
    private Vector<Appartient> appartientList;
    private Vector<Publication> publicationList;
    private Forum forumAdd= new Forum();
    

    public Forum getForumAdd() {
        return forumAdd;
    }

    public void setForumAdd(Forum forumAdd) {
        this.forumAdd = forumAdd;
    }

    public Vector<Appartient> getAppartientList() {
        return appartientList;
    }

    public void setAppartientList(Vector<Appartient> appartientList) {
        this.appartientList = appartientList;
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
    
    public Vector<Appartient> listAppartient(){
        try{
            
            return this.apprtientfacade.findByIdUser(this.user);
            }
       catch(Exception e){
           
        } 
        return null;
    }

   
    public void showPub(Forum idForum){
        try{
            this.publicationList = this.pubfacade.findByIdForum(idForum);
            }
       catch(Exception e){
           
        } 
        
    }
    
    public String addForum(){
        this.forumAdd.setDateCreation(new Date());
        this.forumAdd.setIdUser(this.user);
        this.forumfacade.create(this.forumAdd);
        return null;
    }
    
    @PostConstruct
    public void init() {
        this.user=  (Utilisateur) context.getExternalContext().getSessionMap().get("LoginUser");
        this.appartientList= this.listAppartient();
       
        this.publicationList= new Vector<Publication>() ;
        
    }
}
