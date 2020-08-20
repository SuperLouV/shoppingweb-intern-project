package com.dropshyp.shoppingweb.service;

import com.dropshyp.shoppingweb.dao.CategoryDao;
import com.dropshyp.shoppingweb.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yilinlou
 * @date 8/19/20 7:03 下午
 * @Email:ylou7@stevens.edu
 */

@Service
public class CategoryService {

    //import redis
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisUtil.redisList redisList;

    @Autowired
    private CategoryDao categoryDao;

    public List<String> findDistinctByMain_category(){
        List list = new ArrayList<>();
        if (redisUtil.hasKey("all_mainCategory")){
            list = redisList.get("all_mainCategory",0,-1);
        }else {
            list=categoryDao.findDistinctByMain_category();
            redisList.set("all_mainCategory",list);
        }
        return list;
    }

    public List<String> findSub_category(String main_category){
        return categoryDao.findSub_category(main_category);
    }
}
