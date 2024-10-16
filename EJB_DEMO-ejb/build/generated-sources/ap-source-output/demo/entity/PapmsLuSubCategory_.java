package demo.entity;

import demo.entity.PapmsLuMaterialCategory;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-06T14:52:58")
@StaticMetamodel(PapmsLuSubCategory.class)
public class PapmsLuSubCategory_ { 

    public static volatile SingularAttribute<PapmsLuSubCategory, PapmsLuMaterialCategory> luMatCatId;
    public static volatile SingularAttribute<PapmsLuSubCategory, String> subCatName;
    public static volatile SingularAttribute<PapmsLuSubCategory, String> description;
    public static volatile SingularAttribute<PapmsLuSubCategory, Integer> matCode;
    public static volatile SingularAttribute<PapmsLuSubCategory, Integer> luSubCatId;

}