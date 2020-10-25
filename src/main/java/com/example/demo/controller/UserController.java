package com.example.demo.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@NacosPropertySource(dataId = "mytest1",groupId = "DEFAULT_GROUP",autoRefreshed = true)
public class UserController {

    @Autowired
    private UserService userService;


    @NacosValue(value = "${testname}", autoRefreshed = true)
    String testname;
    @RequestMapping("/users")
    public List<User> getUsers(){
        return userService.getUserList();
    }


    @RequestMapping("/users1")
    public String getUsers1(){
        return testname;
    }

}
