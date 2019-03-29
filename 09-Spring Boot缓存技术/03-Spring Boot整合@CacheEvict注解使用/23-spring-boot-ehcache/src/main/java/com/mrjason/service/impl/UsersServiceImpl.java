package com.mrjason.service.impl;

import com.mrjason.dao.UsersRepository;
import com.mrjason.pojo.Users;
import com.mrjason.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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

    @Cacheable(value = "users")
    public List<Users> findUsersAll() {
        return usersRepository.findAll();
    }

    @Override

    @Cacheable (value = "users")  //指定ehcache文件中的缓存策略
    public Users findUserById(Integer id) {
        return this.usersRepository.findById(id).orElse(null);
    }

    @Override
    // 对分页数据进行缓存处理
    @Cacheable(value = "users" ,key = "#pageable.pageSize")
    public Page<Users> findUserByPage(Pageable pageable) {
        return this.usersRepository.findAll(pageable);
    }

    @Override

    @CacheEvict(value = "users",allEntries = true)  //缓存的清空中以users缓存策略缓存的对象
    public void saveUsers(Users users) {
        this.usersRepository.save(users);
    }
}
