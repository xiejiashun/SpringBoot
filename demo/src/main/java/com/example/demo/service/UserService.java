package com.example.demo.service;

import com.example.demo.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

/**
 * @author ljh
 * @version 1.0
 * @description com.example.demo.service
 * @date 2017/12/15
 */

@Service
public class UserService {
    @Autowired
    private UserDao userDao;


    public Object getUserInfo(@Param("username") String username) {
        return userDao.findByName(username);
    }

    public Object getUserInfo2(@Param("username") String username, @Param("password") Integer password) {
        return userDao.findByNameAndPassword(username, password);
    }

}

