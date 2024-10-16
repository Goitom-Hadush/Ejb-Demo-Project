package demo.entity;

import demo.entity.Address;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-06T14:52:58")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> lName;
    public static volatile SingularAttribute<Users, String> fName;
    public static volatile ListAttribute<Users, Address> addressList;
    public static volatile SingularAttribute<Users, Integer> userId;
    public static volatile SingularAttribute<Users, Date> birthDate;
    public static volatile SingularAttribute<Users, Integer> age;

}