package com.mrjason.dao;

import com.mrjason.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;



/*
JpaSpecificationExecutor  测试

 */
public interface UsersRepositoryJpaSpecificationExecutor extends JpaRepository<Users,Integer> ,JpaSpecificationExecutor<Users>{
}
