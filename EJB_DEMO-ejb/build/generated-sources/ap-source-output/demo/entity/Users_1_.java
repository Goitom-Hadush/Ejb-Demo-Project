package demo.entity;

import demo.entity.Address_1;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-06T14:52:58")
@StaticMetamodel(Users_1.class)
public class Users_1_ { 

    public static volatile SingularAttribute<Users_1, String> lName;
    public static volatile SingularAttribute<Users_1, String> fName;
    public static volatile ListAttribute<Users_1, Address_1> addressList;
    public static volatile SingularAttribute<Users_1, Integer> userId;
    public static volatile SingularAttribute<Users_1, Date> birthDate;
    public static volatile SingularAttribute<Users_1, Integer> age;

}