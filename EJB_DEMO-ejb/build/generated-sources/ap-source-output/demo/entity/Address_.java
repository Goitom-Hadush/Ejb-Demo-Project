package demo.entity;

import demo.entity.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-06T14:52:58")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, Long> phone;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, Users> userId;
    public static volatile SingularAttribute<Address, String> email;
    public static volatile SingularAttribute<Address, Integer> addressId;

}