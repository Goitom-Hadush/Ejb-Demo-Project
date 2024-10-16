package demo.entity;

import demo.entity.PapmsLuSubCategory;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-06T14:52:58")
@StaticMetamodel(PapmsLuMaterialCategory.class)
public class PapmsLuMaterialCategory_ { 

    public static volatile SingularAttribute<PapmsLuMaterialCategory, Integer> luMatCatId;
    public static volatile SingularAttribute<PapmsLuMaterialCategory, String> matCatCode;
    public static volatile ListAttribute<PapmsLuMaterialCategory, PapmsLuSubCategory> papmsLuSubCategoryList;
    public static volatile SingularAttribute<PapmsLuMaterialCategory, String> description;
    public static volatile SingularAttribute<PapmsLuMaterialCategory, String> categoryName;

}