package com.dropshyp.shoppingweb.service;

import com.dropshyp.shoppingweb.dao.UserDao;
import com.dropshyp.shoppingweb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    public User save(User user) {
        return userDao.save(user);
    }

    
    /**
    * @Description: not be used right now
    * @Param: [name, password]
    * @return: com.dropshyp.shoppingweb.domain.User
    * @Author: Yilin Lou
    * @Date: 7/13/20
    */
    public User login(String name, String password) {
        return userDao.findByNameAndPassword(name, password);
    }

    /**
    * @Description: findByName
    * @Param: [name]
    * @return: com.dropshyp.shoppingweb.domain.User
    * @Author: Yilin Lou
    * @Date: 7/13/20
    */
    public User findByName(String name){
        return userDao.findByName(name);
    }
}
