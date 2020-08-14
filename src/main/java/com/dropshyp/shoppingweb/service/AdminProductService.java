package com.dropshyp.shoppingweb.service;

import com.dropshyp.shoppingweb.dao.AdminProductPictureDao;
import com.dropshyp.shoppingweb.dao.UserDao;
import com.dropshyp.shoppingweb.model.Pictures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yilinlou
 * @date 8/13/20 7:31 下午
 * @Email:ylou7@stevens.edu
 */

@Service
public class AdminProductService {

    @Autowired
    private AdminProductPictureDao adminProductPictureDao;

    public Pictures save(Pictures pictures){
        return  adminProductPictureDao.save(pictures);
    }
}
