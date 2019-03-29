package com.mrjason.service.impl;

import com.mrjason.dao.UsersRepository;
import com.mrjason.pojo.Users;
import com.mrjason.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;
    @Override
    public List<Users> findUsersAll() {
        return usersRepository.findAll();
    }

    @Override

    @Cacheable (value = "users")
    public Users findUserById(Integer id) {
        return this.usersRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Users> findUserByPage(Pageable pageable) {
        return this.usersRepository.findAll(pageable);
    }

    @Override
    public void saveUsers(Users users) {
        this.usersRepository.save(users);
    }
}
