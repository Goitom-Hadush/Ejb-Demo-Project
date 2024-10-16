/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.controller;

import demo.bussinessLogic.UserBeanLocal;
import demo.commonApplications.util.Constants;
import demo.commonApplications.util.JsfUtil;
import demo.entity.Address;
import demo.entity.Users;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Yem
 */
@Named(value = "userController")
@ViewScoped
public class UserController implements Serializable {

    @EJB
    UserBeanLocal userBeanlocal;
    @Inject
    Users user;
    @Inject
    Address adress;
    int updteStatus = 0;
    int saveStatus = 0;
    private String saveorUpdateBundle = Constants.getComponentBundle("Create");

    public UserController() {
    }

  

    public Users getUser() {
        if(user==null){
            user=new Users();
        }
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Address getAdress() {
        return adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }

    public String getSaveorUpdateBundle() {
        return saveorUpdateBundle;
    }

    public void setSaveorUpdateBundle(String saveorUpdateBundle) {
        this.saveorUpdateBundle = saveorUpdateBundle;
    }

    public void Creat() {
        if (saveStatus != 1) {
            try {
                userBeanlocal.creat(user);
                JsfUtil.addSuccessMessage("User Created");
                ClearPage();
            } catch (Exception e) {
                JsfUtil.addErrorMessage("Something Error Occured on Data Created");
               
            }
        } else {
            try {
                userBeanlocal.edit(user);
                JsfUtil.addSuccessMessage("User Modified");
                ClearPage();
            } catch (Exception e) {
                JsfUtil.addErrorMessage("Something Error Occured on Data Modified");
                
            }
        }
    }
   public void ClearPage() {
       user=null;
       saveStatus = 0;
       updteStatus = 0;
      
   }  
   
    List<Users> userList = null;
    public List<Users> searchUserInfo(String name) {
        user.setFName(name);
        userList = userBeanlocal.searchUserInfo(user);
        return userList;
    }
      public void getUserInfo(SelectEvent event) {
          String selectUser = event.getObject().toString();
          user.setFName(selectUser);
          user=userBeanlocal.getUserInfo(user);
          saveStatus=1;
          saveorUpdateBundle="update";
      }

}
