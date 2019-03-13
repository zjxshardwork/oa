package com.project.oa.base.controller;

import com.project.oa.base.bean.User;
import com.project.oa.base.service.IRoleService;
import com.project.oa.base.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: UserController
 * @Author: zhanghongkai
 * @Date: Create in 2019/3/5 11:41
 * @Version: 1.0
 */
@Controller
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @RequestMapping("getUser")
    @ResponseBody
    public List<User> getUser(User user){
        return userService.getUser(user);
    }

    @RequestMapping("getUserById")
    @ResponseBody
    public User getUserById(int id){
        return userService.getUserById(id);
    }

    @RequestMapping("deleteUser")
    @ResponseBody
    public String deleteUser(@RequestBody List<User> users){
        String result = "ok";
        try {
            for (User user : users) {
                userService.deleteUser(user);
                roleService.cancelRoleByUserId(Integer.parseInt(user.getId()));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            result = "fail";
        }
        return result;
    }

    @RequestMapping("updateUser")
    @ResponseBody
    public String updateUser(User user){
        String result = "ok";
        try {
            userService.updateUser(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
            result = "fail";
        }
        return result;
    }

    @RequestMapping("addUser")
    @ResponseBody
    public String addUser(User user){
        String result = "ok";
        try {
            if(user.getPassword() == null){
                user.setPassword("000000");
            }
            userService.addUser(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
            result = "fail";
        }
        return result;
    }

    @RequestMapping("getUserByOrgId")
    @ResponseBody
    public List<User> getUserByOrgId(User user){
        return userService.getUserByOrgId(user);
    }

    @RequestMapping("login")
    @ResponseBody
    public String login(String username, String password){
        System.out.println(username);
        System.out.println(password);
        String message = "";
        if("1054733797@qq.com".equals(username) && "123456".equals(password)){
            message = "ok";
        }else{
            message = "帐号或密码错误";
        }
        return message;
    }
}
