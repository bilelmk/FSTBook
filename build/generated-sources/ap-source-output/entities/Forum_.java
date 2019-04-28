package entities;

import entities.Utilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-28T23:38:14")
@StaticMetamodel(Forum.class)
public class Forum_ { 

    public static volatile SingularAttribute<Forum, Utilisateur> idUser;
    public static volatile SingularAttribute<Forum, Date> dateCreation;
    public static volatile SingularAttribute<Forum, Integer> idForum;
    public static volatile SingularAttribute<Forum, String> nom;
    public static volatile ListAttribute<Forum, Utilisateur> utilisateurList;

}