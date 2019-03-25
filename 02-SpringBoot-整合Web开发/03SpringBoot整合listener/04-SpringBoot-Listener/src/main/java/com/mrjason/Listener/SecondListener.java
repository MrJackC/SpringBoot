package com.mrjason.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/*
整合方式二
 */
public class SecondListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("SecondListener........init.....");
    }
}
