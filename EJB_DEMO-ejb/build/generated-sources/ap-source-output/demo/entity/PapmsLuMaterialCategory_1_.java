package demo.entity;

import demo.entity.PapmsLuSubCategory_1;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-06T14:52:58")
@StaticMetamodel(PapmsLuMaterialCategory_1.class)
public class PapmsLuMaterialCategory_1_ { 

    public static volatile SingularAttribute<PapmsLuMaterialCategory_1, Integer> luMatCatId;
    public static volatile SingularAttribute<PapmsLuMaterialCategory_1, String> matCatCode;
    public static volatile ListAttribute<PapmsLuMaterialCategory_1, PapmsLuSubCategory_1> papmsLuSubCategoryList;
    public static volatile SingularAttribute<PapmsLuMaterialCategory_1, String> description;
    public static volatile SingularAttribute<PapmsLuMaterialCategory_1, String> categoryName;

}