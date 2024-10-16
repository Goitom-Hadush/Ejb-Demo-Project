/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.bussinessLogic;

import demo.entity.PapmsLuSubCategory;
import demo.mapper.PapmsLuSubCategoryFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Yem
 */
@Stateless
public class LuMaterialSubCatagoryBean implements LuMaterialSubCatagoryBeanLocal {

    @EJB
    private PapmsLuSubCategoryFacade papmsLuSubCategoryFacadeLocal;

    @Override
    public void saveOrUpdate(PapmsLuSubCategory luSubCategory) {
        papmsLuSubCategoryFacadeLocal.saveOrUpdate(luSubCategory);
    }

    @Override
    public List<PapmsLuSubCategory> findAllmaterialSubCatagoryInfo(PapmsLuSubCategory papmsLuSubCategory) {
        return papmsLuSubCategoryFacadeLocal.findAllmaterialSubCatagoryInfo(papmsLuSubCategory);
    }

    @Override
    public List<PapmsLuSubCategory> findAllmaterialSubCatagory(Integer papmsLuSubCategory) {
        return papmsLuSubCategoryFacadeLocal.findAllmaterialSubCatagory(papmsLuSubCategory);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public PapmsLuSubCategory getPapmsMaterualSubCatInformation(PapmsLuSubCategory papmsLuSubCategory) {

        return papmsLuSubCategoryFacadeLocal.searchLuSubCatInfoForMaterial(papmsLuSubCategory);
    }

    @Override
    public PapmsLuSubCategory getPapmsMaterualSubCatInformationBySubCatId(PapmsLuSubCategory papmsLuSubCategory) {

        return papmsLuSubCategoryFacadeLocal.getPapmsMaterualSubCatInformationBySubCatId(papmsLuSubCategory);
    }

    @Override
    public List<PapmsLuSubCategory> searchMaterialInfoByName(PapmsLuSubCategory papmsLuSubCategory) {
        return papmsLuSubCategoryFacadeLocal.searchMaterialInfoByName(papmsLuSubCategory);
    }

   

    @Override
    public PapmsLuSubCategory serachSubCatInfo(PapmsLuSubCategory category) {
        return papmsLuSubCategoryFacadeLocal.searchLuSubCat(category);
    }

    @Override
    public List<PapmsLuSubCategory> findAllSubCat() {
        return papmsLuSubCategoryFacadeLocal.findAllSubCat();
    }

}
