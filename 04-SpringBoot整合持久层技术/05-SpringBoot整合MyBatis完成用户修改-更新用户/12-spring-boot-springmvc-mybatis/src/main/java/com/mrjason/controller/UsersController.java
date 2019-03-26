package com.mrjason.controller;


import com.mrjason.pojo.Users;
import com.mrjason.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService usersService;


    /*
    页面跳转
     */
    @RequestMapping("/{page}")
    public  String showPage(@PathVariable String page){
        return  page;
    }


    /*
    添加用户
     */
    @RequestMapping("/addUser")
    public String addUser(Users users){
        this.usersService.addUser(users);
        return "OK";
    }
    /*
    查询用户
     */
    @RequestMapping("/findUserAll")
    public String findUserAll(Model model){
        List<Users>  list = this.usersService.findUserAll();
        model.addAttribute("list",list);
        return "showUsers";
    }

    /*
  根据id查询用户
   */
    @RequestMapping("/findUserById")
    public String findUserById(Integer id,Model model){
        Users users = this.usersService.findUsersById(id);
        model.addAttribute("user",users);
        return "updateUser";
    }

    /*
        修改用户
 */
    @RequestMapping("/editUser")
    public String editUser(Users users){
        this.usersService.updataUser(users);
        return "OK";
    }

}
