/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import JavaBeans.AppartientFacade;
import JavaBeans.ForumFacade;
import entities.Appartient;
import entities.Forum;
import entities.Utilisateur;
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
public class rejoindreForum {
    
    FacesContext context = FacesContext.getCurrentInstance();
    @EJB
    private ForumFacade forumfacade ;
    @EJB
    private AppartientFacade apprtientfacade ;
    private Utilisateur user;
    private Vector<Appartient> appartientList = new Vector<Appartient>();
    private Vector<Forum> forumList = new Vector<Forum>();
    private Vector<Forum> autreForum = new Vector<Forum>();
    

    
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
    
    @PostConstruct
    public void init() {
         this.user=  (Utilisateur) context.getExternalContext().getSessionMap().get("LoginUser");
         this.autreForum= autreForum();

    }
    
}
