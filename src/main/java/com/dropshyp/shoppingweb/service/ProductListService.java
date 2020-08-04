package com.dropshyp.shoppingweb.service;

import com.dropshyp.shoppingweb.dao.SupplierDao;
import com.dropshyp.shoppingweb.model.Products;
import com.dropshyp.shoppingweb.model.Suppliers;
import com.dropshyp.shoppingweb.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * This class used to add product information on post-ad.html
 */


/**
 * @author Yilinlou
 * @date 7/21/20 5:50 下午
 * @Email:ylou7@stevens.edu
 */

@Service
public class ProductListService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisUtil.redisList redisList;

    @Autowired
    private SupplierDao supplierDao;

    /**
     * @Description: find All Contact_name
     * @Param: []
     * @return: java.util.List<java.lang.String>
     * @Author: Yilin Lou
     * @Date: 7/21/20
     */
    public List<String> findAllContact_name() {
        List list = new ArrayList<>();
        if (redisUtil.hasKey("allContact_name")){
            list = redisList.get("allContact_name",0,-1);
            System.out.println("read from redis");
        }
        else {
            list=supplierDao.findAllContact_name();
            redisList.set("allContact_name", list);
            System.out.println("read from database");
        }
        return list;

//        return supplierDao.findAllContact_name();
    }

    /**
     * @Description: add a supplier
     * @Param: [suppliers]
     * @return: com.dropshyp.shoppingweb.model.Suppliers
     * @Author: Yilin Lou
     * @Date: 7/29/20
     */
    public Suppliers supplier_save(Suppliers suppliers) {
        return supplierDao.save(suppliers);
    }




}
