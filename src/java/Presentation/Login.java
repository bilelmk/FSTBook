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
import javax.faces.context.FacesContext;

@ManagedBean(name="login")
@RequestScoped
public class Login {
    @EJB 
    private UtilisateurFacade utilisateurFacade ;
    
    FacesContext context = FacesContext.getCurrentInstance();

    private Utilisateur LoginUser;
    private String password;
    private String email;


    public String getPassword() {
        return password;
    }
    
    public Login() {
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
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
    public String connexion(){
        try{
            this.LoginUser= this.utilisateurFacade.findByEmail(this.email);
            if (this.LoginUser.getPassword().equals(this.password)){
                    context.getExternalContext().getSessionMap().put("LoginUser", LoginUser);
                    return "profil" ;

            }
            else{
                return "#" ;
            }

        }catch(Exception e){
            return "#";

        } 
    }
}
