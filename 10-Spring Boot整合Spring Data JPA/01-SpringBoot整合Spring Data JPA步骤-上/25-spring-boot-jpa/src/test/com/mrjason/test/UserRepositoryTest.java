package com.mrjason.test;

import com.mrjason.Application;
import com.mrjason.dao.UserRepositoryByName;
import com.mrjason.dao.UsersRepository;
import com.mrjason.dao.UsersRepositoryCrudRepository;
import com.mrjason.dao.UsersRepositoryQueryAnnotation;
import com.mrjason.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserRepositoryTest {
    @Autowired
    private UsersRepository usersRepository;


    @Autowired
    private UserRepositoryByName userRepositoryByName;


    @Autowired
    private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;

    @Autowired
    private UsersRepositoryCrudRepository usersRepositoryCrudRepository;
    @Test
    public void testSava(){
        Users users = new Users();
        users.setName("hhh");
        users.setAge(18);
        users.setAddress("内蒙古");
        this.usersRepository.save(users);
    }

    @Test
    public void findByName(){
        List<Users> list = this.userRepositoryByName.findByName("hhh");
        for(Users users : list){
            System.out.println(users);
        }
    }


    @Test
    public void findByNameAndAge(){
        List<Users> list = this.userRepositoryByName.findByNameAndAge("hhh",18);
        for(Users users : list){
            System.out.println(users);
        }
    }


    @Test
    public void queryByNameUseHQL(){
        List<Users> list = this.usersRepositoryQueryAnnotation.queryByNameUseHQL("hhh");
        for(Users users : list){
            System.out.println(users);
        }
    }

    @Test
    @Transactional//Transactional与Test  一起使用  事务自动回滚
    @Rollback(false)  //取消回滚
    public void updateUserNameById(){
        this.usersRepositoryQueryAnnotation.updateUsersNameById("666",1);
    }



    /**

     * @Description:    Crud 测试

     * @Author:         MrJason

     * @CreateDate:     2019/3/30 10:00 PM

     * @UpdateUser:     Mrjason

     * @UpdateDate:     2019/3/30 10:00 PM

     * @UpdateRemark:   修改内容

     * @Version:        1.0

     */
    @Test
    public  void CrudRepositorysavaUsers(){
        Users users = new Users();
        users.setAddress("北京市");
        users.setAge(20);
        users.setName("zhansan");
        this.usersRepositoryCrudRepository.save(users);

    }


    /*
    更新数据
     */
    @Test
    public  void CrudRepositoryUpdateUsers(){
        Users users = new Users();
        users.setId(2);
        users.setAddress("南京市");
        users.setAge(40);
        users.setName("zhansan");
        this.usersRepositoryCrudRepository.save(users);

    }

    /*
    查询数据
     */
    @Test
    public  void CrudRepositorySelectUsers(){
         Optional<Users> users = this.usersRepositoryCrudRepository.findById(3);
        System.out.println(users);

    }

    /*
   查询所有数据
    */
    @Test
    public  void CrudRepositorySelectAllUsers(){
        List<Users> list = (List<Users>) this.usersRepositoryCrudRepository.findAll();
        for(Users users :list){
            System.out.println(users);
        }


    }

    /*
   删除数据
    */
    @Test
    public  void CrudRepositorydeleteUsers(){
       this.usersRepositoryCrudRepository.deleteById(3);

    }
}





