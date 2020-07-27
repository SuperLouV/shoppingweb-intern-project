package com.dropshyp.shoppingweb.service;

import com.dropshyp.shoppingweb.dao.ProductDao;
import com.dropshyp.shoppingweb.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

/**
 * @author Yilinlou
 * @date 7/24/20 4:49 下午
 * @Email:ylou7@stevens.edu
 * @Description: This class used as Product Service(includes all CRUD about Product)
 */

@Service
public class ProducService {
    
    @Autowired
    private ProductDao productDao;

    /**
    * @Description: findAllByPages
    * @Param: [pageable]
    * @return: org.springframework.data.domain.Page<com.dropshyp.shoppingweb.model.Products>
    * @Author: Yilin Lou
    * @Date: 7/24/20
    */
    public Page<Products> findAllByPages(Pageable pageable){
        return productDao.findAll(pageable);
    }
    
    /**
    * @Description: save a new product
    * @Param: [products]
    * @return: com.dropshyp.shoppingweb.model.Products
    * @Author: Yilin Lou
    * @Date: 7/24/20
    */
    public Products saveProduct(Products products){
        return productDao.save(products);
    }
    
    
    /**
    * @Description: findByProduct_id
    * @Param: [product_id]
    * @return: com.dropshyp.shoppingweb.model.Products
    * @Author: Yilin Lou
    * @Date: 7/24/20
    */
    public Products findByProduct_id(long product_id){
        return productDao.findByProduct_id(product_id);
    }

    
    
    /**
    * @Description: findAllByCategories
    * @Param: [categories]
    * @return: org.springframework.data.domain.Page<com.dropshyp.shoppingweb.model.Products>
    * @Author: Yilin Lou
    * @Date: 7/24/20
    */
    public Page<Products>  findByCategory_id(String categories,Pageable pageable){
        return productDao.findByCategory_id(categories,pageable);
    }


    /**
    * @Description: This is a test, productDao already has findById()
    * @Param: [id]
    * @return: com.dropshyp.shoppingweb.model.Products
    * @Author: Yilin Lou
    * @Date: 7/24/20
    */
//    public Products findOne(long id) {
//        return productDao.findById(id).get();
//    }


    
}
