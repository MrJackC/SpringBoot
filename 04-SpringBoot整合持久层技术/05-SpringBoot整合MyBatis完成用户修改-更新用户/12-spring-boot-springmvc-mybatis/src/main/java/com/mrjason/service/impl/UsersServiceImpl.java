package com.mrjason.service.impl;


import com.mrjason.mapper.UsersMapper;
import com.mrjason.pojo.Users;
import com.mrjason.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl  implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void addUser(Users users) {
        this.usersMapper.insertUser(users);
    }

    @Override
    public List<Users> findUserAll() {

        return this.usersMapper.selectUsersAll();
    }

    @Override
    public Users findUsersById(Integer id) {
        return this.usersMapper.selectUsersById(id);
    }

    @Override
    public void updataUser(Users users) {
         this.usersMapper.updateUser(users);
    }
}
