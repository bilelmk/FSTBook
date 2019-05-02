/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SADOK
 */
@Entity
@Table(name = "utilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
    , @NamedQuery(name = "Utilisateur.findbyId",query = "SELECT p FROM Utilisateur p WHERE p.idUser = :id")
    , @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom")
    , @NamedQuery(name = "Utilisateur.findByPrenom", query = "SELECT u FROM Utilisateur u WHERE u.prenom = :prenom")
    , @NamedQuery(name = "Utilisateur.findByPassword", query = "SELECT u FROM Utilisateur u WHERE u.password = :password")
    , @NamedQuery(name = "Utilisateur.findByEmail", query = "SELECT u FROM Utilisateur u WHERE u.email = :email")
    , @NamedQuery(name = "Utilisateur.findByOccupation", query = "SELECT u FROM Utilisateur u WHERE u.occupation = :occupation")
    , @NamedQuery(name = "Utilisateur.findBySexe", query = "SELECT u FROM Utilisateur u WHERE u.sexe = :sexe")
     , @NamedQuery(name = "Utilisateur.findBySpecialite", query = "SELECT u FROM Utilisateur u WHERE u.specialite = :specialite")
    
    , @NamedQuery(name = "Utilisateur.findByValide", query = "SELECT u FROM Utilisateur u WHERE u.valide = :valide")})
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "idUser")
    private Integer idUser;
   
    @Column(name = "nom")
    private String nom;
   
    @Column(name = "prenom")
    private String prenom;
    
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "occupation")
    private String occupation;

    @Column(name = "sexe")
    private String sexe;
    
    @Column(name = "age")
    private int age;

    @Column(name = "image")
    private String image="./resources/img/index.png";

    @Column(name = "specialite")
    private String specialite;

   
    @Column(name = "valide")
    private Integer valide = 0;

    

    public Utilisateur() {
    }

    public Utilisateur(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

  

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public Integer getValide() {
        return valide;
    }

    public void setValide(Integer valide) {
        this.valide = valide;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aa.Utilisateur[ idUser=" + idUser + " ]";
    }
    
}
