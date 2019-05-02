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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "forum")
@XmlRootElement
/*@NamedQueries({
    @NamedQuery(name = "Forum.findAll", query = "SELECT f FROM Forum f")
    , @NamedQuery(name = "Forum.findByIdForum", query = "SELECT f FROM Forum f WHERE f.idForum = :idForum")
    , @NamedQuery(name = "Forum.findByNom", query = "SELECT f FROM Forum f WHERE f.nom = :nom")
    , @NamedQuery(name = "Forum.findByDateCreation", query = "SELECT f FROM Forum f WHERE f.dateCreation = :dateCreation")})*/
@NamedQueries({
    @NamedQuery(name = "Forum.findAll", query = "SELECT f FROM Forum f"),
     @NamedQuery(name = "Forum.findById", query = "SELECT p FROM Forum p WHERE p.idForum = :idForum"),
    @NamedQuery(name = "Forum.findByIdUser", query = "SELECT p FROM Forum p WHERE p.idUser = :idUser"),
    //@NamedQuery(name = "Forum.findByIdUser", query = "SELECT p FROM Forum p WHERE p.utilisateurList = :idUser"),
    // @NamedQuery(name = "Forum.findById", query = "SELECT p FROM Forum p WHERE p.idForum = :idForum")
    })

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
        return "aa.Forum[ idForum=" + idForum + " ]";
    }
    
}
