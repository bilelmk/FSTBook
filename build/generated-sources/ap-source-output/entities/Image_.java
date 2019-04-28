package entities;

import entities.Publication;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-28T23:38:14")
@StaticMetamodel(Image.class)
public class Image_ { 

    public static volatile SingularAttribute<Image, String> path;
    public static volatile SingularAttribute<Image, Publication> idPub;
    public static volatile SingularAttribute<Image, Integer> idImage;

}