package com.mrjason.test;

import com.mrjason.Application;
import com.mrjason.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
SpringBoot    测试类
@RunWith   启动类
SpringJUnit4ClassRunner.class  : 让Junit与Spring  环境进行整合
@SpringBootTest(classes = {Application.class })  1，当前类为springboot 的测试类
@SpringBootTest(classes = {Application.class })  2，加载SpringBoot启动类 启动springboot

 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class })
public class UserServiceTest {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Test
    public void testAddUser(){
        this.userServiceImpl.addUser();
    }

}
