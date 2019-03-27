package com.mrjason.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {

    @RequestMapping("/showUsers")
    public String showUsers(){
        String str = null;
        str.length();
        return "index";
    }

    @RequestMapping("/ showUsers2")
    public String showUsers2(){
        int a = 100/0;
        return "index";
    }

}
