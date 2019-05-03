/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package Presentation;

import JavaBeans.ForumFacade;
import JavaBeans.PublicationFacade;


import JavaBeans.UtilisateurFacade;
import entities.Forum;
import entities.Publication;
import entities.Utilisateur;
import java.util.Date;
import java.util.Vector;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name="pub")
@RequestScoped
public class PubView {
    FacesContext context = FacesContext.getCurrentInstance();   
    @EJB
    private PublicationFacade pubfacade ;
    @EJB
    private ForumFacade forumfacade ;

    @EJB 
    private UtilisateurFacade userfacade ;
    
    
    private Vector<Publication> pub = new Vector<Publication>() ;
    private Forum forum ;
    private Forum forump ;
    private Publication publication = new Publication();
    private Utilisateur user;
    private Integer forumid;

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

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public Forum getForump() {
        return forump;
    }

    public void setForump(Forum forump) {
        this.forump = forump;
    }

    public Integer getForumid() {
        return forumid;
    }

    public void setForumid(Integer forumid) {
        this.forumid = forumid;
    }
    
    
    public PubView() {
    }
    
    
    public void getPubByIdForum(){
        this.forum = this.forumfacade.findByid(1);
        this.pub = pubfacade.findByIdForum(this.forum) ;
    }
    

    public Utilisateur getPubUser(int id){
        return this.userfacade.findById(id) ;
    }
    
    public String ajouterPub(){
        System.out.println("sadadadada");
        this.forump= this.forumfacade.findByid(this.forumid);
        this.user=  (Utilisateur) context.getExternalContext().getSessionMap().get("LoginUser");
        this.publication.setDate(new Date());
        this.publication.setIdUser(this.user);
        this.publication.setIdForum(this.forump);
        this.pubfacade.create(this.publication);
        return "profil";
    }
    
    @PostConstruct
    public void init() {
        this.getPubByIdForum();
        
    }
}
*/

package Presentation;

import JavaBeans.ForumFacade;
import JavaBeans.PublicationFacade;


import JavaBeans.UtilisateurFacade;
import entities.Forum;
import entities.Publication;
import entities.Utilisateur;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.Date;
import java.util.Vector;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;


@ManagedBean(name="pub")
@ViewScoped
public class PubView implements Serializable {
    @EJB
    private PublicationFacade pubfacade ;
    @EJB
    private ForumFacade forumfacade ;

    @EJB 
    private UtilisateurFacade userfacade ;
    
    
    private Vector<Publication> pub = new Vector<Publication>() ;
    private Forum forum ;
    private Forum forump ;
    private Publication publication = new Publication();
    private Utilisateur user;
    private Integer forumid;
    
    
    private StreamedContent Downloadfile;

    public StreamedContent getDownloadfile() {
        return Downloadfile;
    }
    
    private Part file ; 
    private Vector<String> fileNameList = new  Vector<String>() ;
    private Vector<Part> fileList = new Vector<Part>() ;

    public Vector<String> getFileNameList() {
        return fileNameList;
    }

    public void setFileNameList(Vector<String> fileNameList) {
        this.fileNameList = fileNameList;
    }

    public Vector<Part> getFileList() {
        return fileList;
    }

    public void setFileList(Vector<Part> fileList) {
        this.fileList = fileList;
    }
    
    
    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    

    public void save() {
        try 
        {
            String fileName = file.getSubmittedFileName();
            fileNameList.add(fileName);
            fileList.add(file);
            System.out.println(fileNameList.size()) ;
        }
        catch (Exception e) {
        }
    }
   
    
   
    

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

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public Forum getForump() {
        return forump;
    }

    public void setForump(Forum forump) {
        this.forump = forump;
    }

    public Integer getForumid() {
        return forumid;
    }

    public void setForumid(Integer forumid) {
        this.forumid = forumid;
    }
    
    
    public PubView() {
    }
    
    
    public void getPubByIdForum(){
        this.forum = this.forumfacade.findByid(1);
        this.pub = pubfacade.findByIdForum(this.forum) ;
    }
    

    public Utilisateur getPubUser(int id){
        return this.userfacade.findById(id) ;
    }
    
    public void ajouterPub(){
        this.forump= this.forumfacade.findByid(this.forumid);
        this.user=  (Utilisateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("LoginUser");
        this.publication.setDate(new Date());
        this.publication.setIdUser(this.user);
        this.publication.setIdForum(this.forump);
        this.pubfacade.create(this.publication);
        
         try{
            for(int i =0 ;i<fileNameList.size();i++){
                InputStream input = fileList.get(i).getInputStream() ;
                Files.copy(input, new File("D:\\",fileNameList.get(i)).toPath());

            }
        }catch(Exception e){
            
        }
         this.fileList = null;
         this.fileNameList = null ;
       
    }
    public StreamedContent download(String fileName ){
        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/upload/"+ fileName);
        Downloadfile = new DefaultStreamedContent(stream, fileName, fileName);
        return this.Downloadfile ;
    } 
    
    
    
    @PostConstruct
    public void init() {
        this.getPubByIdForum();
        
    }
}