package com.mrjason.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: MrJason
 * Date: 2019-03-27
 * Time: 20:29
 */

@Controller
public class UserController {
    @RequestMapping("/show")
    public String showPage(){
        System.out.println("66666.....77777...888...999.......");
        return "index";
    }
}
