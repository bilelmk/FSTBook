package entities;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "utilisateur")
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findByEmail",query = "SELECT p FROM Utilisateur p WHERE p.email = :email"),
    @NamedQuery(name = "Utilisateur.findbyId",query = "SELECT p FROM Utilisateur p WHERE p.idUser = :id"),

})
public class Utilisateur implements Serializable {

   
    @Id
    @GeneratedValue
    @Column(name = "idUser")
    private Integer idUser;
   
    @Column(name = "nom")
    private String nom;
   
    @Column(name = "prenom")
    private String prenom;
    
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "occupation")
    private String occupation;

    @Column(name = "sexe")
    private String sexe;
    
    @Column(name = "age")
    private int age;

    @Column(name = "image")
    private String image="./resources/img/index.png";

    @Column(name = "specialite")
    private String specialite;

   
    @Column(name = "valide")
    private Integer valide = 0;
    
    @ManyToMany(mappedBy = "utilisateurList")
    private List<Forum> forumList;
    

    public Utilisateur() {
    }

    public Utilisateur(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public Integer getValide() {
        return valide;
    }

    public void setValide(Integer valide) {
        this.valide = valide;
    }

    @XmlTransient
    public List<Forum> getForumList() {
        return forumList;
    }

    public void setForumList(List<Forum> forumList) {
        this.forumList = forumList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

   
}
