package com.mrjason.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DemoController {
    @RequestMapping("/{page}")
    public String showInfo(@PathVariable String page,Integer id){
        System.out.println(id);
        return page;
    }
}
