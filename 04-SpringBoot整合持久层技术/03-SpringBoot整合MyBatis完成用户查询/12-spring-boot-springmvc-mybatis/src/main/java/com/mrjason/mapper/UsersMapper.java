package com.mrjason.mapper;

import com.mrjason.pojo.Users;

import java.util.List;

public interface UsersMapper {
    void insertUser(Users users);
    List<Users> selectUsersAll();
}
