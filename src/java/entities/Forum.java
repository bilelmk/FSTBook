/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "forum")

public class Forum implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "idForum")
    private Integer idForum;
    @Column(name = "nom")
    private String nom;
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @JoinTable(name = "appartient", joinColumns = {
        @JoinColumn(name = "idForum", referencedColumnName = "idForum")}, inverseJoinColumns = {
        @JoinColumn(name = "idUser", referencedColumnName = "idUser")})
    @ManyToMany
    private List<Utilisateur> utilisateurList;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private Utilisateur idUser;
    

    public Forum() {
    }

    public Forum(Integer idForum) {
        this.idForum = idForum;
    }

    public Integer getIdForum() {
        return idForum;
    }

    public void setIdForum(Integer idForum) {
        this.idForum = idForum;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @XmlTransient
    public List<Utilisateur> getUtilisateurList() {
        return utilisateurList;
    }

    public void setUtilisateurList(List<Utilisateur> utilisateurList) {
        this.utilisateurList = utilisateurList;
    }

    public Utilisateur getIdUser() {
        return idUser;
    }

    public void setIdUser(Utilisateur idUser) {
        this.idUser = idUser;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idForum != null ? idForum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Forum)) {
            return false;
        }
        Forum other = (Forum) object;
        if ((this.idForum == null && other.idForum != null) || (this.idForum != null && !this.idForum.equals(other.idForum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aaaa.Forum[ idForum=" + idForum + " ]";
    }
    
}
