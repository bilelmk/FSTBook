package entities;

import entities.MessagePK;
import entities.Utilisateur;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-28T23:38:14")
@StaticMetamodel(Message.class)
public class Message_ { 

    public static volatile SingularAttribute<Message, Utilisateur> utilisateur;
    public static volatile SingularAttribute<Message, MessagePK> messagePK;
    public static volatile SingularAttribute<Message, String> contenu;
    public static volatile SingularAttribute<Message, Utilisateur> utilisateur1;

}