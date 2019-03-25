package com.mrjason;



/*
整合方式二
 */

import com.mrjason.Listener.SecondListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application2 {
    public static void main(String[] args) {
        SpringApplication.run(Application2.class,args);
    }

    /*
    注册Listener
     */

    @Bean
    public ServletListenerRegistrationBean<SecondListener> gitServletListenerRegistrationBean(){
        ServletListenerRegistrationBean<SecondListener> bean = new ServletListenerRegistrationBean<SecondListener>(new SecondListener());
        return bean;
    }
}
