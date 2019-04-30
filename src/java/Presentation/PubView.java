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
import java.util.ArrayList;
import java.util.Vector;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="pub")
@RequestScoped
public class PubView {

    @EJB
    private PublicationFacade pubfacade ;
    @EJB
    private ForumFacade forumfacade ;
    
    private Vector<Publication> pub = new Vector<Publication>() ;
    private Forum forum ;

    public void setPub(Vector<Publication> pub) {
        this.pub = pub;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public Vector<Publication> getPub() {
        return pub;
    }

    public Forum getForum() {
        return forum;
    }
    
    
    public PubView() {
    }
    
    
    public void getPubByIdForum(){
        this.forum = this.forumfacade.findByid(1);
        this.pub = pubfacade.findByIdForum(this.forum) ;
    }
    
    @PostConstruct
    public void init() {
        this.getPubByIdForum();
    }
}
