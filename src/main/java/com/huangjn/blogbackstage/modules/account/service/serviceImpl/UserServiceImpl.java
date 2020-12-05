package com.huangjn.blogbackstage.modules.account.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.account.dao.UserDao;
import com.huangjn.blogbackstage.modules.account.dao.UserRoleDao;
import com.huangjn.blogbackstage.modules.account.pojo.Role;
import com.huangjn.blogbackstage.modules.account.pojo.User;
import com.huangjn.blogbackstage.modules.account.service.UserService;
import com.huangjn.blogbackstage.modules.common.vo.Result;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public PageInfo<User> findAllUser(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<User>(
                Optional.ofNullable(userDao.getUsersBySearchVo(searchVo))
                        .orElse(Collections.emptyList()));
    }

    @Override
    @Transactional
    public Result<Object> deleteUserById(int uid) {
        userDao.deleteUserById(uid);
        userRoleDao.deleteByUid(uid);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "删除成功.");
    }

    @Override
    public PageInfo<User> findAllAdministrators(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<User>(
                Optional.ofNullable(userDao.findAllAdministrators(searchVo))
                        .orElse(Collections.emptyList()));
    }

    @Override
    public User findUserByUid(int uid) {
        User user=userDao.findUserByUid(uid);
        List<Role> roles=userRoleDao.findRoleByUid(uid);
        user.setRoles(roles);
        return user;
    }

    @Override
    public Result<User> insertUser(User user) {

        User userTemp = userDao.getUserByUserAccount(user.getAccount());
        if (userTemp != null) {
            return new Result<User>(
                    Result.ResultStatus.FAILED.status, "该账号已被注册");
        }

        userDao.insertUser(user);
        int uid = user.getUid();
        List<Role> roles = user.getRoles();

        for (Role r : roles)
        {
            userRoleDao.insertUserRole(uid,r.getRid());
        }

        return new Result<User>(Result.ResultStatus.SUCCESS.status, "添加成功.");
    }

    @Override
    public Result<User> editUserRole(User user) {

        int uid=user.getUid();
        userRoleDao.deleteByUid(uid);
        List<Role> roles = user.getRoles();
        for (Role r : roles)
        {
            userRoleDao.insertUserRole(uid,r.getRid());
        }
        return new Result<User>(Result.ResultStatus.SUCCESS.status, "修改成功.");
    }
}
