/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import JavaBeans.UtilisateurFacade;
import entities.Utilisateur;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="user")
@RequestScoped
public class UtilisateurView implements Serializable {

    @EJB 
    private UtilisateurFacade utilisateurFacade ;
    private Utilisateur utilisateur = new Utilisateur();
    
    public UtilisateurView() {
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    public String ajoutUtilisateur(){
        this.utilisateurFacade.create(utilisateur);
        return "profil" ;
    }
    
    
}
