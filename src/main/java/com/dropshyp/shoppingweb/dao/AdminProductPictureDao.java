package com.dropshyp.shoppingweb.dao;

import com.dropshyp.shoppingweb.model.Pictures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Yilinlou
 * @date 8/13/20 7:29 下午
 * @Email:ylou7@stevens.edu
 */

@Repository
public interface AdminProductPictureDao extends JpaRepository<Pictures, Long> {

}
