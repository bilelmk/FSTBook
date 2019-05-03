/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import JavaBeans.AppartientFacade;
import JavaBeans.ForumFacade;
import entities.Appartient;
import entities.AppartientPK;
import entities.Forum;
import entities.Utilisateur;
import java.io.Serializable;
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
@Named(value = "rejoindreForum")
@RequestScoped
public class rejoindreForum implements Serializable{
    
    FacesContext context = FacesContext.getCurrentInstance();
    @EJB
    private ForumFacade forumfacade ;
    @EJB
    private AppartientFacade apprtientfacade ;
    private Utilisateur user;
    private Vector<Appartient> appartientList = new Vector<Appartient>();
    private Vector<Forum> forumList = new Vector<Forum>();
    private Vector<Forum> autreForum = new Vector<Forum>();
    private Appartient apprtient = new Appartient();
    private AppartientPK appr= new AppartientPK();
    

    
    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {    
        this.user = user;
    }

    public rejoindreForum() {
    }

    public Vector<Appartient> getAppartientList() {
        return appartientList;
    }

    public void setAppartientList(Vector<Appartient> appartientList) {
        this.appartientList = appartientList;
    }

    public Vector<Forum> getForumList() {
        return forumList;
    }

    public void setForumList(Vector<Forum> forumList) {
        this.forumList = forumList;
    }

    public Vector<Forum> getAutreForum() {
        return autreForum;
    }

    public void setAutreForum(Vector<Forum> autreForum) {
        this.autreForum = autreForum;
    }

    public Appartient getApprtient() {
        return apprtient;
    }

    public void setApprtient(Appartient apprtient) {
        this.apprtient = apprtient;
    }

    
    
    
    
    public Vector<Appartient> listAppartient(){
        try{
            return this.apprtientfacade.findByIdUser(this.user);
            }
       catch(Exception e){} 
        return null;
    }
    
    public Vector<Forum> listForum(){
        try{
            return (Vector<Forum>) this.forumfacade.findAll();
            }
       catch(Exception e){} 
        return null;
    }
    
    public Vector<Forum> autreForum(){
        try{
            this.appartientList= listAppartient();
            this.forumList= listForum();
            
                for(int j=0;j<this.appartientList.size();j++){
                    this.forumList.remove(this.appartientList.get(j).getIdForum());
                    }
                
            
            return this.forumList;
            }
       catch(Exception e){} 
        return null;
    }
    
    public void rejoindreForum(Forum forum){
        this.apprtient.setIdForum(forum);
        this.apprtient.setIdUser(this.user);
        this.appr.setIdForum(forum.getIdForum());
        this.appr.setIdUser(this.user.getIdUser());
        this.apprtient.setAppartientPK(this.appr);
        this.apprtientfacade.create(this.apprtient);
    }
    
    @PostConstruct
    public void init() {
         this.user=  (Utilisateur) context.getExternalContext().getSessionMap().get("LoginUser");
         this.autreForum= autreForum();

    }
    
}
