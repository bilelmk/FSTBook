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

/**
 *
 * @author SADOK
 */
@Entity
@Table(name = "publication")

/*@NamedQueries({
    @NamedQuery(name = "Publication.findAll", query = "SELECT p FROM Publication p")
    , @NamedQuery(name = "Publication.findByIdPub", query = "SELECT p FROM Publication p WHERE p.idPub = :idPub")
    , @NamedQuery(name = "Publication.findByDate", query = "SELECT p FROM Publication p WHERE p.date = :date")
    , @NamedQuery(name = "Publication.findByContenu", query = "SELECT p FROM Publication p WHERE p.contenu = :contenu")})
*/
@NamedQueries({
      @NamedQuery(name = "Publication.findAll", query = "SELECT p FROM Publication p")
    , @NamedQuery(name = "Publication.findByIdPub", query = "SELECT p FROM Publication p WHERE p.idPub = :idPub")
    , @NamedQuery(name = "Publication.findByDate", query = "SELECT p FROM Publication p WHERE p.date = :date")
    , @NamedQuery(name = "Publication.findByContenu", query = "SELECT p FROM Publication p WHERE p.contenu = :contenu")
    , @NamedQuery(  name = "Publication.idForum" ,query = "SELECT p FROM Publication p WHERE p.idForum = :id")})

public class Publication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "idPub")
    private Integer idPub;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    @Column(name = "contenu")
    private String contenu;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private Utilisateur idUser;
    @JoinColumn(name = "idForum", referencedColumnName = "idForum")
    @ManyToOne(optional = false)
    private Forum idForum;
    

    public Publication() {
    }

    public Publication(Integer idPub) {
        this.idPub = idPub;
    }

    public Integer getIdPub() {
        return idPub;
    }

    public void setIdPub(Integer idPub) {
        this.idPub = idPub;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    
    public Utilisateur getIdUser() {
        return idUser;
    }

    public void setIdUser(Utilisateur idUser) {
        this.idUser = idUser;
    }

    public Forum getIdForum() {
        return idForum;
    }

    public void setIdForum(Forum idForum) {
        this.idForum = idForum;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPub != null ? idPub.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publication)) {
            return false;
        }
        Publication other = (Publication) object;
        if ((this.idPub == null && other.idPub != null) || (this.idPub != null && !this.idPub.equals(other.idPub))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aa.Publication[ idPub=" + idPub + " ]";
    }
    
}
