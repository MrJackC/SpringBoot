package com.mrjason;

import com.mrjason.Servlet.SecondServlet;
import com.mrjason.filter.SecondFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;


/*
SpringBoot 整合Filter 方式二
 */
@SpringBootApplication
public class Application2 {
    public static void main(String[] args) {
        SpringApplication.run(Application2.class,args);
    }

/*
注册servlet
 */
    @Bean
    public ServletRegistrationBean gitServletRegistrationBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
        bean.addUrlMappings("/second");
        return  bean;
    }



    /*
    注册filter
     */

    @Bean
    public FilterRegistrationBean gitFilterRegistrationBean(){
        FilterRegistrationBean bean  = new FilterRegistrationBean(new SecondFilter());
//        bean.addUrlPatterns(new String[]{"*.do","*.jsp"});
        bean.addUrlPatterns("/second");
        return bean;
    }
}
