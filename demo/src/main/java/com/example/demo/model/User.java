package com.example.demo.model;

import org.springframework.web.bind.annotation.PathVariable;
import sun.security.util.Password;

import javax.persistence.*;

/**
 * @author ljh
 * @version 1.0
 * @description com.example.demo.model
 * @date 2017/12/16
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    @Column
    private String name ;
    @Column
    private Integer Age;
    @Column
    private Integer password;
    @Column
    private  String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }
}
