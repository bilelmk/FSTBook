package entities;

import entities.Forum;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-30T20:07:58")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ { 

    public static volatile SingularAttribute<Utilisateur, Integer> idUser;
    public static volatile SingularAttribute<Utilisateur, String> image;
    public static volatile SingularAttribute<Utilisateur, String> password;
    public static volatile SingularAttribute<Utilisateur, String> occupation;
    public static volatile SingularAttribute<Utilisateur, String> specialite;
    public static volatile ListAttribute<Utilisateur, Forum> forumList;
    public static volatile SingularAttribute<Utilisateur, String> sexe;
    public static volatile SingularAttribute<Utilisateur, Integer> valide;
    public static volatile SingularAttribute<Utilisateur, String> nom;
    public static volatile SingularAttribute<Utilisateur, String> prenom;
    public static volatile SingularAttribute<Utilisateur, String> email;
    public static volatile SingularAttribute<Utilisateur, Integer> age;

}