package com.mrjason.test;


import com.mrjason.Application;
import com.mrjason.dao.UsersRepository;
import com.mrjason.pojo.Roles;
import com.mrjason.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestOneToMany {

    @Autowired
    private UsersRepository usersRepository;
    /*
    一对多的关联关系的添加
     */

    @Test
    public void testSave(){
        //创建用户
        Users users = new Users();
        users.setName("小米姑娘");
        users.setAge(20);
        users.setAddress("湖南");

        //创建角色
        Roles roles = new Roles();
        roles.setRolename("管理员");

        //关联
        roles.getUsers().add(users);
        users.setRoles(roles);

        //保存
        this.usersRepository.save(users);

    }


    /*
    一对多关系查询
     */
    @Test
    public void select(){
        Optional<Users> users = this.usersRepository.findById(3);
        System.out.println(users);

    }


}
