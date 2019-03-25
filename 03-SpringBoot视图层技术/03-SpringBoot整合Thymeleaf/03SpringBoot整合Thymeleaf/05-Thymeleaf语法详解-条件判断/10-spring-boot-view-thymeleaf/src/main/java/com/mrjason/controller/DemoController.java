package com.mrjason.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: MrJason
 * Date: 2019-03-25
 * Time: 22:42
 * Thymeleaf 入门案例
 */

@Controller
public class DemoController {
    @RequestMapping("/show")
    public  String showInfo(Model model){
        model.addAttribute("msg","Thymeleaf第一个案例");
        return "index";
    }


    @RequestMapping("/show2")
    public  String showInfo2(Model model){
        model.addAttribute("sex","男");
        model.addAttribute("id","2");
        return "index2";
    }

}
