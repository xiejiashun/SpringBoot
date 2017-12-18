package com.example.demo.controller;

import com.example.demo.response.CommonResponse;
import com.example.demo.service.UserService;
import com.example.demo.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.util.Random;
import java.util.logging.Logger;


/**
 * @author ljh
 * @version 1.0
 * @description com.example.demo
 * @date 2017/12/11
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    public ResponseEntity getUserInfo(@RequestParam("username") String username) {
        CommonResponse r = new CommonResponse();
        r.setResult(0);
        r.setErrmsg("");
        ResponseUtil.Result(HttpStatus.OK, r);
        Object userInfo = userService.getUserInfo(username);

        if (userInfo != null) {

            return ResponseUtil.Result(HttpStatus.OK, r);
        }
        //                "{result:0,errmsg:""}"
        else {
            return null;
        }
    }

    @RequestMapping(value = "/checkUserByPassword", method = RequestMethod.POST)
    public Object getUserInfo(@RequestParam("username") String username, @RequestParam("password") Integer password) {

        return userService.getUserInfo2(username, password);
    }

    @RequestMapping(path = "/fileupload", method = RequestMethod.POST)
    public String upload(@RequestParam("File") MultipartFile file) {


//      long s = File.getSize();
//        System.out.print("图片");
        File dest = new File("E:\\maven\\demo\\src\\main\\resources\\static\\image\\test.jpg");
        try {
            file.transferTo(dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        String fileName = File.getOriginalFilename();//获取文件名加后缀
        //将文件保存到本地
        //将文件名用md5加密
        //  writeFileToLocal(File);
        //将文件名保存到数据库
//        。。。


        return "ok";
    }


    private void writeFileToLocal(MultipartFile file) {
        InputStream in = null;
        OutputStream out = null;
        try {
            //输入流
//            in = new FileInputStream("D:/"+File.getName());
            in = file.getInputStream();
            //输出流
            out = new FileOutputStream("E:/maven/demo/src/main/resources/static/images" + file.getName() + ".jpg", false);
            byte[] buffer = new byte[1024];
            while (true) {
                int byteRead = in.read(buffer);
                if (byteRead == -1)
                    break;
                out.write(buffer, 0, byteRead);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
//            System.err.println(args[0] + " is not a URL Java understands.");
        } finally {
            try {
                if (in != null)
                    in.close();
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
