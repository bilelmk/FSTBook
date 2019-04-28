/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author SADOK
 */
@Entity
@Table(name = "commentaire")

public class Commentaire implements Serializable {

    
    @Id
    @GeneratedValue
    @Column(name = "idCom")
    private Integer idCom;
    @Column(name = "contenu")
    private String contenu;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private Utilisateur idUser;
    @JoinColumn(name = "idPub", referencedColumnName = "idPub")
    @ManyToOne(optional = false)
    private Publication idPub;

    public Commentaire() {
    }

    public Commentaire(Integer idCom) {
        this.idCom = idCom;
    }

    public Integer getIdCom() {
        return idCom;
    }

    public void setIdCom(Integer idCom) {
        this.idCom = idCom;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Utilisateur getIdUser() {
        return idUser;
    }

    public void setIdUser(Utilisateur idUser) {
        this.idUser = idUser;
    }

    public Publication getIdPub() {
        return idPub;
    }

    public void setIdPub(Publication idPub) {
        this.idPub = idPub;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCom != null ? idCom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commentaire)) {
            return false;
        }
        Commentaire other = (Commentaire) object;
        if ((this.idCom == null && other.idCom != null) || (this.idCom != null && !this.idCom.equals(other.idCom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aaaa.Commentaire[ idCom=" + idCom + " ]";
    }
    
}
