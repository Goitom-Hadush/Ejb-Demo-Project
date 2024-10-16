/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.mapper;

import demo.entity.PapmsLuMaterialCategory;
import demo.entity.Users;
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
public class UserFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "EJB_DEMO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(Users.class);
    }

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

    public List<Users> searchUserInfo(Users user) {
        Query query = em.createNamedQuery("Users.searchByFName");
        query.setParameter("fName", user.getFName() + "%");
        try {
            List<Users> userList = new ArrayList(query.getResultList());
            return userList;
        } catch (Exception e) {
             e.printStackTrace();
            return null;
        }

    }

    public Users getUserInfo(Users user) {
        Query query = em.createNamedQuery("Users.findByFName", Users.class);
        query.setParameter("fName", user.getFName());
        try {
            Users userselec = (Users) query.getResultList().get(0);
            return userselec;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}



