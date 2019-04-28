/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import JavaBeans.UtilisateurFacade;
import entities.Utilisateur;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author SADOK
 */
@Named(value = "login")
@Dependent
public class Login {
    @EJB 
    private UtilisateurFacade utilisateurFacade ;
    public Utilisateur user;
    public String password;
    public String email;
    /**
     * Creates a new instance of Login
     */
    public Login() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String connexion(){
        System.out.println("aaaa ssad");
        System.out.println(this.password);
        System.out.println(this.email);
        this.user= this.utilisateurFacade.findByEmail("sadok");
        System.out.println(this.password);
        
        if (this.user != null){
            if (this.user.getPassword() == this.password){
                return "profil" ;
            }
        }
        return "profil";
    }
}
