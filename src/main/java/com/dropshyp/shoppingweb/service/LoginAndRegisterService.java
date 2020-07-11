package com.dropshyp.shoppingweb.service;

import com.dropshyp.shoppingweb.dao.UserDao;
import com.dropshyp.shoppingweb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yilinlou
 * @date 7/10/20 9:51 下午
 * @Email:ylou7@stevens.edu
 */

@Service
public class LoginAndRegisterService {
    @Autowired
    private UserDao userDao;
/**
* @Description: add a user
* @Param: [user]
* @return: com.dropshyp.shoppingweb.domain.User
* @Author: Yilin Lou
* @Date: 7/10/20
*/
    public User save(User user){
        return userDao.save(user);
    }
}
