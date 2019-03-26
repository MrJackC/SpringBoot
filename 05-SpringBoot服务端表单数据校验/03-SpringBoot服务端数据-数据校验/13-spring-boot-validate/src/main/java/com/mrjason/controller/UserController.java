package com.mrjason.controller;

import com.mrjason.pojo.Users;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


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

    /*
    完成用户添加
    @Valid   开启对Users对象的校验
    BindingResult   封装了校验的结果
     */
    @RequestMapping("/save")
    public  String saveUser(@Valid  Users users, BindingResult result){
        if(result.hasErrors()){
            return "add";
        }
        System.out.println(users);
        return "ok";
    }
}
