package com.mrjason.test;

import com.mrjason.Application;
import com.mrjason.dao.*;
import com.mrjason.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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


    @Autowired
    private UsersRepositoryPaingAndSorting usersRepositoryPaingAndSorting;

    @Autowired
    private UsersRepositoryJpaSpecificationExecutor usersRepositoryJpaSpecificationExecutor;
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





    /*
   paging and sorting
    */
    @Test
    public void PagingandSortingUsers(){
        //定义排序规则  倒序
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort so = new Sort(order);
        List<Users> users = (List<Users>) this.usersRepositoryPaingAndSorting.findAll(so);
        for(Users users1 :users){
            System.out.println(users1);
        }


    }

    @Test
    public void PagingUsers(){
      //Pageable   封装了分页的参数   当前页  每页显示的条数
        Pageable pageable = new PageRequest(0,2);

        Page<Users> page = this.usersRepositoryPaingAndSorting.findAll(pageable);
        System.out.println("当前总条数"+page.getTotalElements());
        System.out.println("总页数"+page.getTotalPages());
        List<Users> list = page.getContent();
        for(Users users :list) {
            System.out.println(users);
        }
    }

    @Test
    public void  PageAndSort(){
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC,"id"));
        Pageable pageable =new PageRequest(0,2,sort);
        Page<Users> page = this.usersRepositoryPaingAndSorting.findAll(pageable);
        System.out.println("当前总条数"+page.getTotalElements());
        System.out.println("总页数"+page.getTotalPages());
        List<Users> list = page.getContent();
        for(Users users :list) {
            System.out.println(users);
        }
    }

/*
JapRespository  接口测试
 */
    @Test
    public void  testJapRespository(){
        //定义排序规则  倒序
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort so = new Sort(order);
        List<Users> users = this.usersRepository.findAll(so);
        for(Users users1 :users){
            System.out.println(users1);
        }
    }





    /*
    JpaSpecificationExecutor 测试   单条件
     */


    @Test
    public void testJpaSpecificationExecutor(){
        Specification<Users> specification = new Specification<Users>() {
            //Predicate 封装了单个的查询条件   一个Predicate就是一个查询条件
            //Root  查询对象的属性的封装   也就是对象的包装类
            //CriteriaQuery query   封装了查询信息select  delete
            //CriteriaBuilder  查询条件的构造器
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                //  where  name  = 张三
                //equal   需要两个参数   参数一   当前要查询的属性   参数二    条件的值

                Predicate predicate = criteriaBuilder.equal(root.get("name"), "zhansan");
                return predicate;
            }
        };
        List<Users> list = this.usersRepositoryJpaSpecificationExecutor.findAll(specification);
        for(Users users : list){
            System.out.println(users);
        }
    }


    /*
    JpaSpecificationExecutor 测试   多条件
     */


    @Test
    public void testJpaSpecificationExecutorS(){
        Specification<Users> specification = new Specification<Users>() {
            //Predicate 封装了单个的查询条件   一个Predicate就是一个查询条件
            //Root  查询对象的属性的封装   也就是对象的包装类
            //CriteriaQuery query   封装了查询信息select  delete
            //CriteriaBuilder  查询条件的构造器
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                //  where  name  = 张三   age = 40
                //equal   需要两个参数   参数一   当前要查询的属性   参数二    条件的值
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.equal(root.get("name"),"zhansan"));
                list.add(criteriaBuilder.equal(root.get("age"),"40"));
                Predicate[] predicates = new Predicate[list.size()];
                Predicate predicate = criteriaBuilder.and(list.toArray(predicates));
                return predicate;
            }
        };
        List<Users> list = this.usersRepositoryJpaSpecificationExecutor.findAll(specification);
        for(Users users : list){
            System.out.println(users);
        }
    }
}





