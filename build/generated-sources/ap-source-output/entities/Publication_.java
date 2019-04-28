package entities;

import entities.Commentaire;
import entities.Document;
import entities.Forum;
import entities.Image;
import entities.Utilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-28T23:38:14")
@StaticMetamodel(Publication.class)
public class Publication_ { 

    public static volatile SingularAttribute<Publication, Date> date;
    public static volatile SingularAttribute<Publication, Utilisateur> idUser;
    public static volatile ListAttribute<Publication, Commentaire> commentaireList;
    public static volatile SingularAttribute<Publication, Integer> idPub;
    public static volatile ListAttribute<Publication, Document> documentList;
    public static volatile SingularAttribute<Publication, Forum> idForum;
    public static volatile SingularAttribute<Publication, String> contenu;
    public static volatile ListAttribute<Publication, Image> imageList;

}