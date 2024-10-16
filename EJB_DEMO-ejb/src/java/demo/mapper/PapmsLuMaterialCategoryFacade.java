/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.mapper;

import demo.entity.PapmsLuMaterialCategory;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Yem
 */
@Stateless
public class PapmsLuMaterialCategoryFacade extends AbstractFacade<PapmsLuMaterialCategory> {

    @PersistenceContext(unitName = "EJB_DEMO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PapmsLuMaterialCategoryFacade() {
        super(PapmsLuMaterialCategory.class);
    }
  public PapmsLuMaterialCategory getPapmsMaterualCatInformation(PapmsLuMaterialCategory luMaterialCategory) {

        Query query = em.createNamedQuery("PapmsLuMaterialCategory.findByCategoryName", PapmsLuMaterialCategory.class);
        query.setParameter("categoryName", luMaterialCategory.getCategoryName());
        try {
            PapmsLuMaterialCategory luMaterialCatInfo = (PapmsLuMaterialCategory) query.getResultList().get(0);
            return luMaterialCatInfo;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //added for bid
    public PapmsLuMaterialCategory searchAllMaterialInformationByCategory(PapmsLuMaterialCategory materialCategory) {
        Query query = em.createNamedQuery("PapmsLuMaterialCategory.findByLuMatCatId", PapmsLuMaterialCategory.class);
        query.setParameter("luMatCatId", materialCategory.getLuMatCatId());
        try {
            PapmsLuMaterialCategory luMaterialCatInfo = (PapmsLuMaterialCategory) query.getResultList().get(0);
            return luMaterialCatInfo;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<PapmsLuMaterialCategory> searchCatNameInformation(PapmsLuMaterialCategory materialCategory) {
        Query query = em.createNamedQuery("PapmsLuMaterialCategory.findByCategoryName1");
        query.setParameter("categoryName", materialCategory.getCategoryName() + "%");
        System.out.println("dgdg" + materialCategory.getCategoryName());
        try {
            ArrayList<PapmsLuMaterialCategory> categorys = new ArrayList(query.getResultList());
            return categorys;
        } catch (Exception ex) {
            return null;
        }
    }

    public boolean getCategoryDup(PapmsLuMaterialCategory materialCategory) {
        boolean duplicaton;
        Query query = em.createNamedQuery("PapmsLuMaterialCategory.findByCatNameAndCatCode", PapmsLuMaterialCategory.class);
        query.setParameter("categoryName", materialCategory.getCategoryName());
        query.setParameter("matCatCode", materialCategory.getMatCatCode());
        try {
            if (query.getResultList().size() > 0) {
                duplicaton = true;
            } else {
                duplicaton = false;
            }
            return duplicaton;
        } catch (Exception ex) {
            return false;
        }
    }

   
   

}
