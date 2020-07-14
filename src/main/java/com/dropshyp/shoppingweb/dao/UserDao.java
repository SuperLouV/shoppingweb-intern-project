package com.dropshyp.shoppingweb.dao;

import com.dropshyp.shoppingweb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author Yilinlou
 * @date 7/8/20 5:07 下午
 * @Email:ylou7@stevens.edu
 */

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    /**
     * search user by username
     * @param name
     * @return
     */
    User findByName(String name);

    User findByNameAndPassword(String name,String password);



}
