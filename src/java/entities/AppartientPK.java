/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author SADOK
 */
@Embeddable
public class AppartientPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idUser")
    private int idUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idForum")
    private int idForum;

    public AppartientPK() {
    }

    public AppartientPK(int idUser, int idForum) {
        this.idUser = idUser;
        this.idForum = idForum;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdForum() {
        return idForum;
    }

    public void setIdForum(int idForum) {
        this.idForum = idForum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUser;
        hash += (int) idForum;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppartientPK)) {
            return false;
        }
        AppartientPK other = (AppartientPK) object;
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.idForum != other.idForum) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aa.AppartientPK[ idUser=" + idUser + ", idForum=" + idForum + " ]";
    }
    
}
