package com.example.demo.repository;

import com.example.demo.model.User;
import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ljh
 * @version 1.0
 * @description com.example.demo.repository
 * @date 2017/12/15
 */

public interface UserDao extends CrudRepository<User,Integer> {
    @Query( "select u from User u where username=?1")
    User findByName(String username);

    @Query("select u from User u where u.username=?1 and u.password = ?2" )
    User findByNameAndPassword(String username, Integer password);

}
