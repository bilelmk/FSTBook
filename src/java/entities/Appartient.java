/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SADOK
 */
@Entity
@Table(name = "appartient")
@NamedQueries({
    @NamedQuery(name = "Appartient.findAll", query = "SELECT a FROM Appartient a")
    , @NamedQuery(name = "Appartient.findByIdUser", query = "SELECT a FROM Appartient a WHERE a.idUser = :idUser")
    , @NamedQuery(name = "Appartient.findByIdForum", query = "SELECT a FROM Appartient a WHERE a.idForum = :idForum")
    , @NamedQuery(name = "Appartient.findByValide", query = "SELECT a FROM Appartient a WHERE a.valide = :valide")})
public class Appartient implements Serializable {

    
    @EmbeddedId
    protected AppartientPK appartientPK;
    @Column(name = "valide")
    private Integer valide;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilisateur idUser;
    @JoinColumn(name = "idForum", referencedColumnName = "idForum", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Forum idForum;

    public Appartient() {
    }

    public Appartient(AppartientPK appartientPK) {
        this.appartientPK = appartientPK;
    }

    public Appartient(int idUser, int idForum) {
        this.appartientPK = new AppartientPK(idUser, idForum);
    }

    public AppartientPK getAppartientPK() {
        return appartientPK;
    }

    public void setAppartientPK(AppartientPK appartientPK) {
        this.appartientPK = appartientPK;
    }

    public Integer getValide() {
        return valide;
    }

    public void setValide(Integer valide) {
        this.valide = valide;
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
        hash += (appartientPK != null ? appartientPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appartient)) {
            return false;
        }
        Appartient other = (Appartient) object;
        if ((this.appartientPK == null && other.appartientPK != null) || (this.appartientPK != null && !this.appartientPK.equals(other.appartientPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aa.Appartient[ appartientPK=" + appartientPK + " ]";
    }
    
}
