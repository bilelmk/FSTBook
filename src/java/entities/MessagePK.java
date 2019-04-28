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


@Embeddable
public class MessagePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idUser")
    private int idUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uti_idUser")
    private int utiidUser;

    public MessagePK() {
    }

    public MessagePK(int idUser, int utiidUser) {
        this.idUser = idUser;
        this.utiidUser = utiidUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getUtiidUser() {
        return utiidUser;
    }

    public void setUtiidUser(int utiidUser) {
        this.utiidUser = utiidUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUser;
        hash += (int) utiidUser;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessagePK)) {
            return false;
        }
        MessagePK other = (MessagePK) object;
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.utiidUser != other.utiidUser) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aaaa.MessagePK[ idUser=" + idUser + ", utiidUser=" + utiidUser + " ]";
    }
    
}
