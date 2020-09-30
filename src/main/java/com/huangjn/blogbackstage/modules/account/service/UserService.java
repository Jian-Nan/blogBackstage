package com.huangjn.blogbackstage.modules.account.service;


import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.account.pojo.User;
import com.huangjn.blogbackstage.modules.common.vo.Result;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;

public interface UserService {
    PageInfo<User> findAllUser(SearchVo searchVo);

    Result<Object> deleteUserById(int uid);

    PageInfo<User> findAllAdministrators(SearchVo searchVo);

    User findUserByUid(int uid);

    Result<User> insertUser(User user);

    Result<User> editUserRole(User user);
}
