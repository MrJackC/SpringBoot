package com.mrjason.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: MrJason
 * Date: 2019-03-26
 * Time: 21:59
 * SpringBoot  处理方式一   自定义错误页面
 */
@Controller
public class DemoController {
    @RequestMapping("/show")
    public String  showInfo(){
        String str = null;
        str.length();
        return "index";
    }

    @RequestMapping("/show2")
    public String  showInfo2(){
        int a = 100/0;
        return "index";
    }




}
