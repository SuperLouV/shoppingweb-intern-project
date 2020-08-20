package com.dropshyp.shoppingweb.dao;

import com.dropshyp.shoppingweb.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yilinlou
 * @date 8/19/20 6:52 下午
 * @Email:ylou7@stevens.edu
 */
@Repository
public interface CategoryDao extends JpaRepository<Categories, Long> {
    @Query(value = "select distinct main_category from Categories ",nativeQuery = true)
    List<String> findDistinctByMain_category();


    @Query(value = "select sub_category from categories where main_category=?",nativeQuery = true)
    List<String> findSub_category(String main_category);

}