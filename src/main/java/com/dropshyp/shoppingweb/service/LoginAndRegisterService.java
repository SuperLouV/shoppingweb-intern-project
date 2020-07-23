package com.dropshyp.shoppingweb.service;

import com.dropshyp.shoppingweb.dao.UserDao;
import com.dropshyp.shoppingweb.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yilinlou
 * @date 7/10/20 9:51 下午
 * @Email:ylou7@stevens.edu
 */

@Service
public class LoginAndRegisterService  {
    @Autowired
    private UserDao userDao;

    /**
     * @Description: add a user
     * @Param: [user]
     * @return: com.dropshyp.shoppingweb.domain.User
     * @Author: Yilin Lou
     * @Date: 7/10/20
     */
//    public Users save(Users users) {
//        return userDao.save(users);
//    }

    /**
    * @Description: not be used right now
    * @Param: [username, password]
    * @return: com.dropshyp.shoppingweb.domain.User
    * @Author: Yilin Lou
    * @Date: 7/13/20
    */
//    public Users login(String username, String password) {
//        return userDao.findByUsernameAndPassword(username, password);
//    }

    /**
    * @Description: findByName
    * @Param: [username]
    * @return: com.dropshyp.shoppingweb.domain.User
    * @Author: Yilin Lou
    * @Date: 7/13/20
    */
//    public Users findByName(String username){
//        return userDao.findByUsername(username);
//    }
}
