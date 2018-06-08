package com.controller;

import com.entity.User;
import com.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("user")
    public String  getUser(){
        StringBuilder sb = new StringBuilder();
        List<User> list = userMapper.findByUsername();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
            sb.append(list.get(i).toString());
        }
        return sb.toString();
    }

}
