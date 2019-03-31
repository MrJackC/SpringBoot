package com.mrjason.dao;

import com.mrjason.pojo.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**

 * @Description:    Repository  Query

 * @Author:         MrJason

 * @CreateDate:     2019/3/30 3:48 PM

 * @UpdateUser:     Mrjason

 * @UpdateDate:     2019/3/30 3:48 PM

 * @UpdateRemark:   修改内容

 * @Version:        1.0

 */

public interface UsersRepositoryQueryAnnotation extends Repository<Users,Integer> {
//    报错  是否是编辑器或者spring版本的问题   只能使用正确的sql语句来写
//    @Query(value = "from Users where name = ? ")
//    List<Users>  queryByNameUseHQL(String name);


    @Query(value = "select * from t_users where name = ?",nativeQuery = true)
    List<Users>  queryByNameUseHQL(String name);


    //更新数据的操作
    @Query(value = "update t_users set name = ? where id = ?",nativeQuery = true)
    @Modifying //只需要一个更新操作
    void updateUsersNameById (String name,Integer id);
}
