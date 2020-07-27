package com.dropshyp.shoppingweb.dao;

import com.dropshyp.shoppingweb.model.Shops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yilinlou
 * @date 7/27/20 5:12 下午
 * @Email:ylou7@stevens.edu
 */

@Repository
public interface ShopsDao extends JpaRepository<Shops, Long> {

    /**
     * @Description: findByShop_id
     * @Param: [id]
     * @return: com.dropshyp.shoppingweb.model.Shops
     * @Author: Yilin Lou
     * @Date: 7/27/20
     */
    @Query(value = "SELECt shop from shops where shop.shop_id= ?", nativeQuery = true)
    Shops findByShop_id(long id);


    /**
     * @Description: deleteByJPQL
     * @Param: [shop_id]
     * @return: int
     * @Author: Yilin Lou
     * @Date: 7/27/20
     */
    @Transactional
    @Modifying
    @Query(value = "delete from Shops shop where shop.shop_id=?1")
    int deleteShops(long shop_id);



    /**
    * @Description: insert into shops_products
    * @Param: [shop_id, product_id]
    * @return: void
    * @Author: Yilin Lou
    * @Date: 7/27/20
    */
    @Query(value = "insert INTO shops_products VALUES(?1, ?2)", nativeQuery = true)
    void insert(long shop_id,long product_id);




}
