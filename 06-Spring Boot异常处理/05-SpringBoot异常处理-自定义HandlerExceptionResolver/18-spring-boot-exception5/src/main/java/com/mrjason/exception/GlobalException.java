package com.mrjason.exception;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

/**
 * 实现HandlerExceptionResolver全局异常处理类
 *
 *
 */
@Configuration
public class GlobalException implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        //判断不同异常类型  跳转不同视图
        if(e instanceof  ArithmeticException){
            mv.setViewName("error1");
        }
        if (e instanceof NullPointerException){
            mv.setViewName("error2");
        }
        mv.addObject("error",e.toString());
        return mv;

    }
}



