package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.dao.UserDao;
import com.baizhi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("login")
    public @ResponseBody String login(User user){
        User user1 = userService.login(user);
        if(user1==null){
            return "110";
        }else{
            return "111";
        }




    }
    @RequestMapping("regist")
    public @ResponseBody void regist(User user) {userService.add(user);
    }
    @RequestMapping("update")
    public @ResponseBody void update(User user){
        userService.motify(user);
    }
}
