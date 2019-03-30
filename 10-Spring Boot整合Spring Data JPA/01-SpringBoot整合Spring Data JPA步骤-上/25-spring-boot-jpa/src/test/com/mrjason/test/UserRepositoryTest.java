package com.mrjason.test;

import com.mrjason.Application;
import com.mrjason.dao.UsersRepository;
import com.mrjason.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserRepositoryTest {
    @Autowired
    private UsersRepository usersRepository;

    @Test
    public void testSava(){
        Users users = new Users();
        users.setName("hhh");
        users.setAge(18);
        users.setAddress("内蒙古");
        this.usersRepository.save(users);
    }

}
