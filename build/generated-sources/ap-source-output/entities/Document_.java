package entities;

import entities.Publication;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-28T23:38:14")
@StaticMetamodel(Document.class)
public class Document_ { 

    public static volatile SingularAttribute<Document, String> path;
    public static volatile SingularAttribute<Document, Publication> idPub;
    public static volatile SingularAttribute<Document, Integer> idDoc;

}