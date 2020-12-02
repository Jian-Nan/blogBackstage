package com.huangjn.blogbackstage.modules.account.service;

import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.account.pojo.Role;
import com.huangjn.blogbackstage.modules.account.pojo.User;
import com.huangjn.blogbackstage.modules.common.vo.Result;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;

import java.util.List;

public interface RoleService {
    PageInfo<Role> findAllRoles(SearchVo searchVo);

    List<Role> getRoles();

    Result<User> insertRole(String roleName);

    Result<User> deleteRoleById(int rid);

    Role findRoleByRid(int rid);
}
