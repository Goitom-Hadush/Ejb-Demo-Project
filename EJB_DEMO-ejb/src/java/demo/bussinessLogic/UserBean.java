/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.bussinessLogic;

import demo.entity.Users;
import demo.mapper.UserFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Yem
 */
@Stateless
public class UserBean implements UserBeanLocal {
    @EJB 
    UserFacade userFacade;
    @Override
    public void creat(Users user) {
      userFacade.create(user);
    }

    @Override
    public void edit(Users user) {
       userFacade.edit(user);
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Users> searchUserInfo(Users user) {
      return userFacade.searchUserInfo(user);  
    }

    @Override
    public Users getUserInfo(Users user) {
     return userFacade.getUserInfo(user);
    }

  
}
