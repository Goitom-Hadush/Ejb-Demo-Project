/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.mapper;

import demo.entity.PapmsLuMaterialCategory;
import demo.entity.PapmsLuSubCategory;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Yem
 */
@Stateless
public class PapmsLuSubCategoryFacade extends AbstractFacade<PapmsLuSubCategory> {

    @PersistenceContext(unitName = "EJB_DEMO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PapmsLuSubCategoryFacade() {
        super(PapmsLuSubCategory.class);
    }
    
 public List<PapmsLuSubCategory> findAllmaterialSubCatagoryInfo(PapmsLuSubCategory LuSubCategoryObj) {
        List<PapmsLuSubCategory> luSubCategoryInfo = null;
        try {
            Query query = em.createNamedQuery("PapmsLuSubCategory.findByCatId", PapmsLuSubCategory.class);
            query.setParameter("storeNamess", LuSubCategoryObj.getLuMatCatId());
            luSubCategoryInfo = query.getResultList();
        } catch (Exception e) {
            return null;
        }
        return luSubCategoryInfo;
    }

    public List<PapmsLuSubCategory> findAllmaterialSubCatagory(Integer LuSubCategoryObj) {
        List<PapmsLuSubCategory> luSubCategoryInfo = null;
        try {

            System.out.println("=============LuSubCategoryObj.getLuCatId()==========" + LuSubCategoryObj);
            Query query = em.createNamedQuery("PapmsLuSubCategory.findByCatInfoId", PapmsLuSubCategory.class);
            System.out.println("test   " + query);
            query.setParameter("luMatCatId", LuSubCategoryObj);
            System.out.println("test ewe  " + query);
            luSubCategoryInfo = query.getResultList();
            System.out.println("List============================#####=====" + query.getResultList().size() + "=====" + luSubCategoryInfo);
        } catch (Exception e) {
            return null;
        }
        return luSubCategoryInfo;
    }
//    @Override
//    public List<PapmsLuSubCategory> getPapmsMaterualSubCatInformation(PapmsLuSubCategory papmsLuSubCategory) {
//
//        List<PapmsLuSubCategory> luMaterialSubCategorys = null;
//        try {
//            Query query = em.createNamedQuery("PapmsLuMaterialCategory.findAll", PapmsLuSubCategory.class);
//            luMaterialSubCategorys = (List<PapmsLuSubCategory>) query.getResultList();
//        } catch (Exception e) {
//            return null;
//        }
//        return luMaterialSubCategorys;
//    }

    public PapmsLuSubCategory getPapmsMaterualSubCatInformation(PapmsLuSubCategory papmsLuSubCategory) {

        Query query = em.createNamedQuery("PapmsLuSubCategory.findByName", PapmsLuSubCategory.class);
        query.setParameter("SubcatagoryName", papmsLuSubCategory.getSubCatName());
//        query.setParameter("luCatId", papmsLuSubCategory.getLuMatCatId());
        try {
            PapmsLuSubCategory luMaterialSubCatInfo = (PapmsLuSubCategory) query.getResultList().get(0);
            return luMaterialSubCatInfo;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<PapmsLuSubCategory> searchMaterialInfoByName(PapmsLuSubCategory papmsLuSubCategory) {
        List<PapmsLuSubCategory> luMaterialSubCategorys = null;
        try {
            Query query = em.createNamedQuery("PapmsLuSubCategory.findByCataforyName", PapmsLuSubCategory.class);
            query.setParameter("subCatName", papmsLuSubCategory.getSubCatName() + "%");
            luMaterialSubCategorys = query.getResultList();

            return luMaterialSubCategorys;
        } catch (Exception e) {
            return null;
        }
    }

    /////added for bid
    public PapmsLuSubCategory getPapmsMaterualSubCatInformationBySubCatId(PapmsLuSubCategory papmsLuSubCategory) {

        Query query = em.createNamedQuery("PapmsLuSubCategory.findById");
        query.setParameter("luSubCatId", papmsLuSubCategory.getLuSubCatId());
        try {
            PapmsLuSubCategory luMaterialSubCatInfo = (PapmsLuSubCategory) query.getResultList().get(0);
            return luMaterialSubCatInfo;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

   
    public List<PapmsLuMaterialCategory> findCatagoryByStoreinformation(String storeName1) {
        List<PapmsLuMaterialCategory> luSubCategoryInfo = new ArrayList<>();
        try {
            System.out.println("storrrrrrrrrr" + storeName1);
            if (storeName1 != null) {
                Query query = em.createNativeQuery("SELECT DISTINCT PAPMS_STORE_INFORMATION.STORE_NAME,\n"
                        + "  PAPMS_LU_MATERIAL_CATEGORY.CATEGORY_NAME,\n"
                        + "  PAPMS_STORE_INFORMATION.STORE_ID,\n"
                        + "  PAPMS_LU_MATERIAL_CATEGORY.LU_MAT_CAT_ID\n"
                        + "FROM PAPMS_STORE_INFORMATION\n"
                        + "INNER JOIN PAPMS_MATERIAL_INFORMATION\n"
                        + "ON PAPMS_STORE_INFORMATION.STORE_ID = PAPMS_MATERIAL_INFORMATION.STORE_ID\n"
                        + "INNER JOIN PAPMS_LU_SUB_CATEGORY\n"
                        + "ON PAPMS_LU_SUB_CATEGORY.ID = PAPMS_MATERIAL_INFORMATION.LU_MAT_SUB_CAT_ID\n"
                        + "INNER JOIN PAPMS_LU_MATERIAL_CATEGORY\n"
                        + "ON PAPMS_LU_MATERIAL_CATEGORY.LU_MAT_CAT_ID = PAPMS_LU_SUB_CATEGORY.LU_CAT_ID\n"
                        + "WHERE PAPMS_STORE_INFORMATION.STORE_NAME    = '" + storeName1 + "'", PapmsLuMaterialCategory.class);
                luSubCategoryInfo = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return luSubCategoryInfo;
    }

    public List<PapmsLuSubCategory> findSubCatByStoreAndCate(String storeName1, String materialCategorys) {
        System.out.println("store and category facade");
        List<PapmsLuSubCategory> luSubCategoryInfo = new ArrayList<>();
        try {
            // if (store != null && cat != null) {
            Query query = em.createNativeQuery("SELECT DISTINCT PAPMS_LU_SUB_CATEGORY.NAME,\n"
                    + "PAPMS_LU_SUB_CATEGORY.ID\n"
                    + "FROM PAPMS_STORE_INFORMATION\n"
                    + "INNER JOIN PAPMS_MATERIAL_INFORMATION PAPMS_MATERIAL_INFORMATION1\n"
                    + "ON PAPMS_STORE_INFORMATION.STORE_ID = PAPMS_MATERIAL_INFORMATION1.STORE_ID\n"
                    + "INNER JOIN PAPMS_LU_SUB_CATEGORY\n"
                    + "ON PAPMS_LU_SUB_CATEGORY.ID = PAPMS_MATERIAL_INFORMATION1.LU_MAT_SUB_CAT_ID\n"
                    + "INNER JOIN PAPMS_LU_MATERIAL_CATEGORY\n"
                    + "ON PAPMS_LU_MATERIAL_CATEGORY.LU_MAT_CAT_ID = PAPMS_LU_SUB_CATEGORY.LU_CAT_ID\n"
                    + "WHERE PAPMS_STORE_INFORMATION.STORE_NAME  = '" + storeName1 + "' and PAPMS_LU_MATERIAL_CATEGORY.CATEGORY_NAME = '" + materialCategorys + "'", PapmsLuSubCategory.class);
            luSubCategoryInfo = query.getResultList();
            //  }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return luSubCategoryInfo;
    }

    public PapmsLuSubCategory searchLuSubCat(PapmsLuSubCategory papmsLuSubCategory) {

        Query query = em.createNamedQuery("PapmsLuSubCategory.findByNameCat", PapmsLuSubCategory.class);
        query.setParameter("SubcatagoryName", papmsLuSubCategory.getSubCatName());

        try {
            PapmsLuSubCategory luMaterialSubCatInfo = (PapmsLuSubCategory) query.getResultList().get(0);
            return luMaterialSubCatInfo;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public PapmsLuSubCategory searchLuSubCatInfoForMaterial(PapmsLuSubCategory papmsLuSubCategory) {

        Query query = em.createNamedQuery("PapmsLuSubCategory.findByName", PapmsLuSubCategory.class);
        query.setParameter("SubcatagoryName", papmsLuSubCategory.getSubCatName());
        query.setParameter("luMatCatId", papmsLuSubCategory.getLuMatCatId());

        try {
            PapmsLuSubCategory luMaterialSubCatInfo = (PapmsLuSubCategory) query.getResultList().get(0);
            return luMaterialSubCatInfo;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public PapmsLuSubCategory searchLuSubCatInfoForMedicine(PapmsLuSubCategory papmsLuSubCategory) {

        Query query = em.createNamedQuery("PapmsLuSubCategory.findByNameCat", PapmsLuSubCategory.class);
        query.setParameter("SubcatagoryName", papmsLuSubCategory.getSubCatName());

        try {
            PapmsLuSubCategory luMaterialSubCatInfo = (PapmsLuSubCategory) query.getResultList().get(0);
            return luMaterialSubCatInfo;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<PapmsLuSubCategory> findAllSubCat() {
        List<PapmsLuSubCategory> luSubCategoryInfo;
        try {
            Query query = em.createNamedQuery("PapmsLuSubCategory.findAll", PapmsLuSubCategory.class);
            luSubCategoryInfo = query.getResultList();
            return luSubCategoryInfo;
        } catch (Exception e) {
            return null;
        }

    }

}
