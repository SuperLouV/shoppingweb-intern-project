package com.dropshyp.shoppingweb.dao;

import com.dropshyp.shoppingweb.model.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yilinlou
 * @date 7/21/20 4:32 下午
 * @Email:ylou7@stevens.edu
 */

@Repository
public interface SupplierDao extends JpaRepository<Suppliers, Long> {

    /**
     * @Description: find distinct contact_name from suppliers
     * @Param: [contact_name]
     * @return: java.util.List<com.dropshyp.shoppingweb.model.Suppliers>
     * @Author: Yilin Lou
     * @Date: 7/21/20
     */
//    List<String> findDistinctByContact_name(String contact_name);
    @Query(value = "SELECt distinct contact_name from suppliers", nativeQuery = true)
    List<String> findAllContact_name();
    /**
     * find a Object according to contact_name
     *
     * @param contact_name
     * @return
     */
//    Suppliers findByContact_name(String contact_name);
    // 使用命名参数传递参数
    @Query(value = "SELECT p FROM Suppliers p where p.contact_name = :contact_name")
    List<Suppliers> queryFirstByContact_name(@Param("contact_name") String contact_name);
}
