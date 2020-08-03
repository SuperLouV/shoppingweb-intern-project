package com.dropshyp.shoppingweb.dao;

import com.dropshyp.shoppingweb.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Yilinlou
 * @date 7/8/20 5:07 下午
 * @Email:ylou7@stevens.edu
 */

@Repository
public interface UserDao extends JpaRepository<Users, Long> {

    Users findByUsername(String username);

    Users findByUsernameAndPassword(String username, String password);


}
