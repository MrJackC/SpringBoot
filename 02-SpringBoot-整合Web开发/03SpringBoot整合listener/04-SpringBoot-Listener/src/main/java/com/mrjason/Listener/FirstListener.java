package com.mrjason.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/*
Springboot 整合Listener
 *
 *<listener>
 *	<listener-class>com.bjsxt.listener.FirstListener</listener-class>
 *</listener>
 */
@WebListener
public class FirstListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Listener ........  init .....");

    }
}
