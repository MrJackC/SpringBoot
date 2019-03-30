package com.mrjason.dao;

import com.mrjason.pojo.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsersRepositoryPaingAndSorting extends PagingAndSortingRepository<Users,Integer>{

}
