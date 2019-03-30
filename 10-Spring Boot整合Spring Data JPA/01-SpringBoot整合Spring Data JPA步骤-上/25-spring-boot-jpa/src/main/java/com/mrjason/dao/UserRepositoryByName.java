package com.mrjason.dao;

import com.mrjason.pojo.Users;
import org.springframework.data.repository.Repository;

import java.util.List;

/**

 * @Description:    Repository 接口的方法命名查询
 * @Author:         MrJason

 * @CreateDate:     2019/3/30 3:23 PM

 * @UpdateUser:     Mrjason

 * @UpdateDate:     2019/3/30 3:23 PM

 * @UpdateRemark:   修改内容

 * @Version:        1.0

 */
public interface UserRepositoryByName extends Repository<Users,Integer>{
    //方法名必须遵循驼峰命名规则

    List<Users>  findByName(String name);

    List<Users>  findByNameAndAge(String name,Integer age);

}
