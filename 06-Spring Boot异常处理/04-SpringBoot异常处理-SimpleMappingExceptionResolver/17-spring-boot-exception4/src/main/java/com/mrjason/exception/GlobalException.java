package com.mrjason.exception;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * 全局异常处理类
 *
 *
 */
@Configuration
public class GlobalException {

    /*
    该方法必要要有返回值   而且返回值的类型必须为SimpleMappingExceptionResolver

     */
    @Bean
    public SimpleMappingExceptionResolver gitSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        //两个参数的含义
        //参数一   表示参数的类型
        //参数二   视图名称

        mappings.put("java.lang.ArithmeticException", "error1");
        //设置异常与视图信息
        mappings.put("java.lang.NullPointerException", "error2");
        simpleMappingExceptionResolver.setExceptionMappings(mappings);

        return  simpleMappingExceptionResolver;
    }
}



