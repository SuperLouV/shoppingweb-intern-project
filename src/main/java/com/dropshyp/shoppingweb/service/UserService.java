package com.dropshyp.shoppingweb.service;

import com.dropshyp.shoppingweb.dao.ShopsDao;
import com.dropshyp.shoppingweb.dao.UserDao;
import com.dropshyp.shoppingweb.model.Shops;
import com.dropshyp.shoppingweb.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yilinlou
 * @date 7/27/20 5:56 下午
 * @Email:ylou7@stevens.edu
 */

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    ShopsDao shopsDao;

    /**
    * @Description: delete_shop_update_user
    * @Param: [users] return null if there is no shop
    * @return: com.dropshyp.shoppingweb.model.Users
    * @Author: Yilin Lou
    * @Date: 7/27/20
    */
    @Transactional
    public Users delete_shop_update_user(Users users){
        Shops shop=users.getShop();
        if (shop==null)
            return null;
        shopsDao.deleteShops(shop.getShop_id());
        return userDao.save(users);
    }
}
