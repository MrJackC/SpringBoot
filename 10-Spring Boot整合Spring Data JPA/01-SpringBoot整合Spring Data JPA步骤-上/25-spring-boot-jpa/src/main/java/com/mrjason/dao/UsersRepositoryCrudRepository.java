package com.mrjason.dao;

import com.mrjason.pojo.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepositoryCrudRepository extends CrudRepository<Users,Integer> {

}
