/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author SADOK
 */
@Entity
@Table(name = "document")
public class Document implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "idDoc")
    private Integer idDoc;
    @Column(name = "path")
    private String path;
    @JoinColumn(name = "idPub", referencedColumnName = "idPub")
    @ManyToOne(optional = false)
    private Publication idPub;

    public Document() {
    }

    public Document(Integer idDoc) {
        this.idDoc = idDoc;
    }

    public Integer getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(Integer idDoc) {
        this.idDoc = idDoc;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
        hash += (idDoc != null ? idDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.idDoc == null && other.idDoc != null) || (this.idDoc != null && !this.idDoc.equals(other.idDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aaaa.Document[ idDoc=" + idDoc + " ]";
    }
    
}
