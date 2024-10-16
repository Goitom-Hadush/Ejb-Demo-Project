/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.bussinessLogic;

import demo.entity.PapmsLuMaterialCategory;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Yem
 */
@Local
public interface PapmsLuMaterialCatagoryBeanLocal {

    public List<PapmsLuMaterialCategory> findAllmaterialCatagoryInfo();

    public PapmsLuMaterialCategory getPapmsMaterualCatInformation(PapmsLuMaterialCategory luMaterialCategory);

    void create(PapmsLuMaterialCategory luMaterialCategory);

    void edit(PapmsLuMaterialCategory luMaterialCategory);
    public ArrayList<PapmsLuMaterialCategory> searchCatNameInformation(PapmsLuMaterialCategory materialCategory);

    public boolean getCategoryDup(PapmsLuMaterialCategory materialCategory);
//public  ArrayList<PapmsLuMaterialCategory> searchTsa(PapmsLuMaterialCategory materialCategory);
}

