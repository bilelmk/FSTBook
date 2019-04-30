
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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


@Entity
@Table(name = "publication")
@XmlRootElement
@NamedQueries({
      @NamedQuery(name = "Publication.findAll", query = "SELECT p FROM Publication p")
    , @NamedQuery(name = "Publication.findByIdPub", query = "SELECT p FROM Publication p WHERE p.idPub = :idPub")
    , @NamedQuery(name = "Publication.findByDate", query = "SELECT p FROM Publication p WHERE p.date = :date")
    , @NamedQuery(name = "Publication.findByContenu", query = "SELECT p FROM Publication p WHERE p.contenu = :contenu")
    , @NamedQuery(  name = "Publication.idForum" ,query = "SELECT p FROM Publication p WHERE p.idForum = :id")})
public class Publication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPub")
    private Integer idPub;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 254)
    @Column(name = "contenu")
    private String contenu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPub")
    private List<Image> imageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPub")
    private List<Document> documentList;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private Utilisateur idUser;
    @JoinColumn(name = "idForum", referencedColumnName = "idForum")
    @ManyToOne(optional = false)
    private Forum idForum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPub")
    private List<Commentaire> commentaireList;

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

    @XmlTransient
    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    @XmlTransient
    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
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

    @XmlTransient
    public List<Commentaire> getCommentaireList() {
        return commentaireList;
    }

    public void setCommentaireList(List<Commentaire> commentaireList) {
        this.commentaireList = commentaireList;
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

   
}
