package com.mrjason.service;

import com.mrjason.pojo.Users;

import java.util.List;

public interface UsersService {
    void addUser(Users users);
    List<Users> findUserAll();
    Users findUsersById(Integer id);
}
