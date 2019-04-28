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
import javax.persistence.Table;

@Entity
@Table(name = "message")

public class Message implements Serializable {

    
    @EmbeddedId
    protected MessagePK messagePK;
    @Column(name = "contenu")
    private String contenu;
    @JoinColumn(name = "uti_idUser", referencedColumnName = "idUser", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur1;

    public Message() {
    }

    public Message(MessagePK messagePK) {
        this.messagePK = messagePK;
    }

    public Message(int idUser, int utiidUser) {
        this.messagePK = new MessagePK(idUser, utiidUser);
    }

    public MessagePK getMessagePK() {
        return messagePK;
    }

    public void setMessagePK(MessagePK messagePK) {
        this.messagePK = messagePK;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Utilisateur getUtilisateur1() {
        return utilisateur1;
    }

    public void setUtilisateur1(Utilisateur utilisateur1) {
        this.utilisateur1 = utilisateur1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (messagePK != null ? messagePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.messagePK == null && other.messagePK != null) || (this.messagePK != null && !this.messagePK.equals(other.messagePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aaaa.Message[ messagePK=" + messagePK + " ]";
    }
    
}
