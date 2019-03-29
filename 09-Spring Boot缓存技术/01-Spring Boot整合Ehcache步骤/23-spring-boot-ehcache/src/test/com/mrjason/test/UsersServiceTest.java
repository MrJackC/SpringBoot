package com.mrjason.test;

import com.mrjason.Application;
import com.mrjason.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UsersServiceTest {
    @Autowired
    private UsersService usersService;
    @Test
    public void testFindUsersById(){
        System.out.println(this.usersService.findUserById(1));
        System.out.println(this.usersService.findUserById(1));
    }
}
