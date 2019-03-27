package com.mrjason.controller;

import com.mrjason.pojo.Users;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;



/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: MrJason
 * Date: 2019-03-26
 * Time: 20:42
 * SpringBoot 表单数据的校验
 */
@Controller
public class UserController {
    @RequestMapping("/addUser")
    public  String showPage(){
        return "add";
    }

    @RequestMapping("/save")
    public  String saveUser(Users users){
        System.out.println(users);
        return "ok";
    }
}
