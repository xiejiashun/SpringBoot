package com.example.demo.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by Administrator on 2016-06-12.
 */
public class ResponseUtil
{
    public static ResponseEntity Result(HttpStatus status, Object data) {
        return new ResponseEntity<Object>(data,status);
    }
}
