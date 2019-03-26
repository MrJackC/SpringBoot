package com.mrjason.controller;


import com.mrjason.pojo.Users;
import com.mrjason.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService usersService;


    /*
    页面跳转
     */
    @RequestMapping("/{page}")
    public  String showPage(@PathVariable String page){
        return  page;
    }


    /*
    添加用户
     */
    @RequestMapping("/addUser")
    public String addUser(Users users){
        this.usersService.addUser(users);
        return "OK";
    }
}
