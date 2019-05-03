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
import java.io.Serializable;
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
public class FormsView implements Serializable {
    
    FacesContext context = FacesContext.getCurrentInstance();
    @EJB
    private ForumFacade forumfacade ;
    @EJB
    private PublicationFacade pubfacade ;
    @EJB
    private AppartientFacade apprtientfacade ;
    private Utilisateur user;
    private Vector<Appartient> appartientList;
    private Vector<Appartient> appartientListValid;
    private Vector<Publication> publicationList;
    private Forum forumAdd= new Forum();
    private Vector<Forum> mesForums = new Vector<Forum>();
    private Vector<Appartient> listDemandes= new Vector<Appartient>();
    

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

    public Vector<Appartient> getAppartientListValid() {
        return appartientListValid;
    }

    public void setAppartientListValid(Vector<Appartient> appartientListValid) {
        this.appartientListValid = appartientListValid;
    }

    public Vector<Forum> getMesForums() {
        return mesForums;
    }

    public void setMesForums(Vector<Forum> mesForums) {
        this.mesForums = mesForums;
    }

    public Vector<Appartient> getListDemandes() {
        return listDemandes;
    }

    public void setListDemandes(Vector<Appartient> listDemandes) {
        this.listDemandes = listDemandes;
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
    
    public Vector<Appartient> listAppartient(Vector<Appartient> listappr, Vector<Appartient> listapprVald){
        try{
            listappr=this.apprtientfacade.findByIdUser(this.user);
            for(int i=0; i<listappr.size();i++){
                if(listappr.get(i).getValide() == 1){
                    listapprVald.add(listappr.get(i));
                }
            }
            return listapprVald;
            
            }
       catch(Exception e){
           
        } 
        return null;
    }
    
  /*  public Vector<Appartient> listAppartientValid(){
        try{
            for(int i=0; i<this.appartientList.size();i++){
                if(this.appartientList.get(i).getValide() == 1){
                    this.appartientListValid.add(this.appartientList.get(i));
                }
            }
            return this.appartientListValid;
            }
       catch(Exception e){
           
        } 
        return null;
    }
*/
   
    public void showPub(Forum idForum){
        try{
            this.publicationList = this.pubfacade.findByIdForum(idForum);
            }
       catch(Exception e){
           
        } 
        
    }
    
    public Vector<Publication> show(Forum idForum){
        return this.pubfacade.findByIdForum(idForum);
    }
    
    public String addForum(){
        this.forumAdd.setDateCreation(new Date());
        this.forumAdd.setIdUser(this.user);
        this.forumfacade.create(this.forumAdd);
        return null;
    }
    
    public Vector<Forum> mesForum(){
        return this.forumfacade.findByIdUser(this.user);
    }
    
     public Vector<Appartient> listDemande(Forum forum){
        try{
            Vector<Appartient> listappr;
            Vector<Appartient> listapprVald=new Vector<Appartient>();
            listappr=this.apprtientfacade.findByIdForum(forum);
            for(int i=0; i<listappr.size();i++){
                if(listappr.get(i).getValide() == 0){
                    listapprVald.add(listappr.get(i));
                }
            }
            return listapprVald;
            }
       catch(Exception e){
           
        } 
        return null;
        
    }
     
     
     public void accepter(Forum forum, Utilisateur user){
         /*Appartient appr = new Appartient();
         appr.setIdForum(forum);
         appr.setIdUser(user);
         appr.setValide(1);
         this.apprtientfacade.edit(appr);*/
         System.out.println("kljlkjlkj");
         System.out.println(forum);
         System.out.println(forum.getNom());
         System.out.println(user);
         System.out.println(user.getNom());
         this.apprtientfacade.updateValide(forum, user);
     }
    
    
    @PostConstruct
    public void init() {
        this.user=  (Utilisateur) context.getExternalContext().getSessionMap().get("LoginUser");
        this.appartientList= listAppartient(new Vector<Appartient>() , new Vector<Appartient>());
        //this.appartientListValid= listAppartientValid();
        this.publicationList= new Vector<Publication>() ;
        this.mesForums = mesForum();
        
    }
}
