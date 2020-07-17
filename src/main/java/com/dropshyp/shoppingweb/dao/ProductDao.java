package com.dropshyp.shoppingweb.dao;

import com.dropshyp.shoppingweb.model.Products;
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
     * @Description: findAllByCategories
     * @Param: [categories]
     * @return: java.util.List<com.dropshyp.shoppingweb.model.Products>
     * @Author: Yilin Lou
     * @Date: 7/17/20
     */
    List<Products> findAllByCategories(String categories);

    /**
     * @Description: deleteAllByCategories
     * @Param: [categories]
     * @return: java.util.List<com.dropshyp.shoppingweb.model.Products>
     * @Author: Yilin Lou
     * @Date: 7/17/20
     */
    List<Products> deleteAllByCategories(String categories);


}
