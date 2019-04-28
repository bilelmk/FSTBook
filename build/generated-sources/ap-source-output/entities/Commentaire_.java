package entities;

import entities.Publication;
import entities.Utilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-28T23:38:14")
@StaticMetamodel(Commentaire.class)
public class Commentaire_ { 

    public static volatile SingularAttribute<Commentaire, Integer> idCom;
    public static volatile SingularAttribute<Commentaire, Date> date;
    public static volatile SingularAttribute<Commentaire, Utilisateur> idUser;
    public static volatile SingularAttribute<Commentaire, Publication> idPub;
    public static volatile SingularAttribute<Commentaire, String> contenu;

}