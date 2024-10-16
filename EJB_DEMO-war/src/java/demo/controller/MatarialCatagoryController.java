/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.controller;

import demo.bussinessLogic.PapmsLuMaterialCatagoryBeanLocal;
import demo.entity.PapmsLuMaterialCategory;
import demo.entity.PapmsLuSubCategory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;
import demo.commonApplications.util.JsfUtil;
import demo.commonApplications.util.Constants;


/**
 *
 * @author Yem
 */
@Named(value = "matarialCatagoryController")
@ViewScoped
public class MatarialCatagoryController implements Serializable {

    @EJB
    private PapmsLuMaterialCatagoryBeanLocal luMaterialCatagoryBeanLocal;
    @Inject
    private PapmsLuMaterialCategory materialCategory;
    @Inject
    private PapmsLuSubCategory subCategory;

    public MatarialCatagoryController() {
    }
    private String saveorUpdateBundle = Constants.getComponentBundle("Create");
    int updteStatus = 0;
    int saveStatus = 0;
    DataModel<PapmsLuSubCategory> papmsLuSubModel;
    String duplicattion = null;

    public String getSaveorUpdateBundle() {
        return saveorUpdateBundle;
    }

    public void setSaveorUpdateBundle(String saveorUpdateBundle) {
        this.saveorUpdateBundle = saveorUpdateBundle;
    }

    public PapmsLuMaterialCategory getMaterialCategory() {
        if (this.materialCategory == null) {
            this.materialCategory = new PapmsLuMaterialCategory();
        }
        return materialCategory;
    }

    public void setMaterialCategory(PapmsLuMaterialCategory materialCategory) {
        this.materialCategory = materialCategory;
    }

    public PapmsLuSubCategory getSubCategory() {
        if (subCategory == null) {
            subCategory = new PapmsLuSubCategory();
        }
        return subCategory;
    }

    public void setSubCategory(PapmsLuSubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public DataModel<PapmsLuSubCategory> getPapmsLuSubModel() {
        if (papmsLuSubModel == null) {
            papmsLuSubModel = new ArrayDataModel<>();
        }
        return papmsLuSubModel;
    }

    public void setPapmsLuSubModel(DataModel<PapmsLuSubCategory> papmsLuSubModel) {
        this.papmsLuSubModel = papmsLuSubModel;
    }

    public void save() {
        System.out.println("checking at save");
        if (saveStatus != 1) {

            System.out.println("in save");
            subCategory.setLuMatCatId(materialCategory);
            luMaterialCatagoryBeanLocal.create(materialCategory);
            JsfUtil.addSuccessMessage("material catagory info saved successfully!");

        } else {
            System.out.println("checking at edit");
            luMaterialCatagoryBeanLocal.edit(materialCategory);
            JsfUtil.addSuccessMessage("material catagory info Modified successfully!");

        }
        clearPage();
    }

    public String clearPage() {
        materialCategory = null;
        subCategory = null;
        papmsLuSubModel = null;
        updteStatus = 0;
        saveStatus = 0;
        duplicattion = null;
        saveorUpdateBundle = "Create";
        return null;
    }
    Set<String> subCategoryCheck = new HashSet<>();

    public String addDetail() {

        if (!subCategoryCheck.contains(subCategory.getSubCatName())) {

            materialCategory.add(subCategory);
            recreateModelDetail();
            subCategoryCheck.add(subCategory.getSubCatName());
            return clearPopup();
        } else {
            duplicattion = "Data Table Row Duplicated";
            JsfUtil.addErrorMessage("Sub Cat Name: Value is Duplicated");
            return "";
        }
    }

    public void recreateModelDetail() {
        papmsLuSubModel = null;
        papmsLuSubModel = new ListDataModel(new ArrayList<>(materialCategory.getPapmsLuSubCategoryList()));
    }

    public String clearPopup() {
        subCategory = null;
        duplicattion = null;
        return null;
    }

    public void updateLocationInfoDetail() {

        subCategory = getPapmsLuSubModel().getRowData();
    }
    List<PapmsLuMaterialCategory> papmsMCNList = null;

    public List<PapmsLuMaterialCategory> searchMatCatInformation(String catName) {
        materialCategory.setCategoryName(catName);
        papmsMCNList = luMaterialCatagoryBeanLocal.searchCatNameInformation(materialCategory);
        return papmsMCNList;
    }

    public void getMatCatInfo(SelectEvent event) {
        String selectPapmssiv = event.getObject().toString();
        materialCategory.setCategoryName(selectPapmssiv);
        materialCategory = luMaterialCatagoryBeanLocal.getPapmsMaterualCatInformation(materialCategory);
        saveStatus = 1;
        saveorUpdateBundle = "Update";
        recreateModelDetail();
    }

    public void updatesubcategoryDetail() {
        subCategory = getPapmsLuSubModel().getRowData();
    }

}
