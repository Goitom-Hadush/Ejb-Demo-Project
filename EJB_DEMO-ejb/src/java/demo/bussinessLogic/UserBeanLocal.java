/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.bussinessLogic;

import demo.entity.Users;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Yem
 */
@Local
public interface UserBeanLocal {

    public void creat(Users user);

    public void edit(Users user);
    public List<Users> searchUserInfo(Users user);

    public Users getUserInfo(Users user);
    
}
