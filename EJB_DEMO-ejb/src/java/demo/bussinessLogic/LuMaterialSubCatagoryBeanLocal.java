/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.bussinessLogic;

import demo.entity.PapmsLuSubCategory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Yem
 */
@Local
public interface LuMaterialSubCatagoryBeanLocal {

    public List<PapmsLuSubCategory> findAllmaterialSubCatagoryInfo(PapmsLuSubCategory papmsLuSubCategory);

    public List<PapmsLuSubCategory> findAllmaterialSubCatagory(Integer papmsLuSubCategory);

    public PapmsLuSubCategory getPapmsMaterualSubCatInformation(PapmsLuSubCategory papmsLuSubCategory);

    public PapmsLuSubCategory getPapmsMaterualSubCatInformationBySubCatId(PapmsLuSubCategory papmsLuSubCategory);

    public List<PapmsLuSubCategory> searchMaterialInfoByName(PapmsLuSubCategory papmsLuSubCategory);

    public PapmsLuSubCategory serachSubCatInfo(PapmsLuSubCategory category);

    public List<PapmsLuSubCategory> findAllSubCat();

    public void saveOrUpdate(PapmsLuSubCategory luSubCategory);

}

