/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.bussinessLogic;

import demo.entity.PapmsLuMaterialCategory;
import demo.mapper.PapmsLuMaterialCategoryFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Yem
 */
@Stateless
public class PapmsLuMaterialCatagoryBean implements PapmsLuMaterialCatagoryBeanLocal {

    @EJB
    private PapmsLuMaterialCategoryFacade papmsLuMaterialCategoryFacadeLocal;

    @Override
    public List<PapmsLuMaterialCategory> findAllmaterialCatagoryInfo() {
        return papmsLuMaterialCategoryFacadeLocal.findAll();
    }

    @Override
    public PapmsLuMaterialCategory getPapmsMaterualCatInformation(PapmsLuMaterialCategory luMaterialCategory) {
        return papmsLuMaterialCategoryFacadeLocal.getPapmsMaterualCatInformation(luMaterialCategory);
    }

    @Override
    public void create(PapmsLuMaterialCategory luMaterialCategory) {
        papmsLuMaterialCategoryFacadeLocal.create(luMaterialCategory);
    }

    @Override
    public void edit(PapmsLuMaterialCategory luMaterialCategory) {
        papmsLuMaterialCategoryFacadeLocal.edit(luMaterialCategory);
    }

    @Override
    public ArrayList<PapmsLuMaterialCategory> searchCatNameInformation(PapmsLuMaterialCategory materialCategory) {
        return papmsLuMaterialCategoryFacadeLocal.searchCatNameInformation(materialCategory);
    }

    @Override
    public boolean getCategoryDup(PapmsLuMaterialCategory materialCategory) {
        return papmsLuMaterialCategoryFacadeLocal.getCategoryDup(materialCategory);
    }
}
