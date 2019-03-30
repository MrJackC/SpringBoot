package com.mrjason.test;

import com.mrjason.Application;
import com.mrjason.dao.UserRepositoryByName;
import com.mrjason.dao.UsersRepository;
import com.mrjason.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserRepositoryTest {
    @Autowired
    private UsersRepository usersRepository;


    @Autowired
    private UserRepositoryByName userRepositoryByName;
    @Test
    public void testSava(){
        Users users = new Users();
        users.setName("hhh");
        users.setAge(18);
        users.setAddress("内蒙古");
        this.usersRepository.save(users);
    }

    @Test
    public void findByName(){
        List<Users> list = this.userRepositoryByName.findByName("hhh");
        for(Users users : list){
            System.out.println(users);
        }
    }


    @Test
    public void findByNameAndAge(){
        List<Users> list = this.userRepositoryByName.findByNameAndAge("hhh",18);
        for(Users users : list){
            System.out.println(users);
        }
    }
}
