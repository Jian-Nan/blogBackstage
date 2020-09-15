package com.huangjn.blogbackstage.modules.account.controller;

import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.account.pojo.User;
import com.huangjn.blogbackstage.modules.account.service.UserService;
import com.huangjn.blogbackstage.modules.common.vo.Result;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/findAllUser")
    PageInfo<User> findAllUser(@RequestBody SearchVo searchVo) {
        return userService.findAllUser(searchVo);
    }

    @DeleteMapping("/deleteUserById/{uid}")
    Result<Object> deleteUserById(@PathVariable int uid) {
        return userService.deleteUserById(uid);
    }

    @PostMapping("/findAllAdministrators")
    PageInfo<User> findAllAdministrators(@RequestBody SearchVo searchVo) {
        return userService.findAllAdministrators(searchVo);
    }

    @GetMapping("/findUserByUid/{uid}")
    User findUserByUid(@PathVariable int uid)
    {
        return userService.findUserByUid(uid);
    }

}
