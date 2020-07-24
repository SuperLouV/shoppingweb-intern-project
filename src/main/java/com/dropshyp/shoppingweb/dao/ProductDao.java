package com.dropshyp.shoppingweb.dao;

import com.dropshyp.shoppingweb.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yilinlou
 * @date 7/17/20 5:50 下午
 * @Email:ylou7@stevens.edu
 */

@Repository

public interface ProductDao extends JpaRepository<Products, Long> {

    /**
     * @Description: findAllByCategories        根据商品所属列表显示商品 return Page<>
     * @Param: [categories]
     * @return: java.util.List<com.dropshyp.shoppingweb.model.Products>
     * @Author: Yilin Lou
     * @Date: 7/17/20
     */
    Page<Products> findAllByCategories(String categories);



    /**
     * @Description: deleteAllByCategories      删除某一类商品
     * @Param: [categories]
     * @return: java.util.List<com.dropshyp.shoppingweb.model.Products>
     * @Author: Yilin Lou
     * @Date: 7/17/20
     */
    List<Products> deleteAllByCategories(String categories);

    /**
     * @Description: findByProduct_id ||find one item according to product_id
     * @Param: [id]
     * @return: com.dropshyp.shoppingweb.model.Products
     * @Author: Yilin Lou
     * @Date: 7/24/20
     */
    Products findByProduct_id(long id);

    /**
     * @Description: find All products, return Pages
     * @Param: [pageable]
     * @return: org.springframework.data.domain.Page<Book>
     * @Author: Yilin Lou
     * @Date: 7/24/20
     */
    Page<Products> findAll(Pageable pageable);



}
