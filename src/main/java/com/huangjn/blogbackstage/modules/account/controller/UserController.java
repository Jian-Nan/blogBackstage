package com.huangjn.blogbackstage.modules.account.controller;

import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.common.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @PostMapping("/findAllUser")
    PageInfo<User> findAllUser(){
        return null;
    }
}
