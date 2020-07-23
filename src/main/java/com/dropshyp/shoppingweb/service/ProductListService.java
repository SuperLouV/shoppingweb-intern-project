package com.dropshyp.shoppingweb.service;

import com.dropshyp.shoppingweb.dao.SupplierDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yilinlou
 * @date 7/21/20 5:50 下午
 * @Email:ylou7@stevens.edu
 */

@Service
public class ProductListService {
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
        return supplierDao.findAllContact_name();
    }
}
