/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import JavaBeans.UtilisateurFacade;
import entities.Utilisateur;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="utilisateur")
@RequestScoped
public class UtilisateurView {

    @EJB 
    private UtilisateurFacade utilisateurFacade ;
    private Utilisateur utilisateur ;
    private int nb ;

    public void setNb(int nb) {
        this.nb = nb;
    }

    public int getNb() {
        return nb;
    }
    
    
    
    public UtilisateurView() {
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    public String ajoutUtilisateur(){
        
        this.nb = this.utilisateurFacade.findAll().size();
        return "profil";
    }
}
