package com.huangjn.blogbackstage.modules.account.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.account.dao.RoleDao;
import com.huangjn.blogbackstage.modules.account.pojo.Role;
import com.huangjn.blogbackstage.modules.account.pojo.User;
import com.huangjn.blogbackstage.modules.account.service.RoleService;
import com.huangjn.blogbackstage.modules.common.vo.Result;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public PageInfo<Role> findAllRoles(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<Role>(
                Optional.ofNullable(roleDao.findAllRoles(searchVo))
                        .orElse(Collections.emptyList()));
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }

    @Override
    public Result<User> insertRole(String roleName) {
        roleDao.insertRole(roleName);
        return new Result<User>(Result.ResultStatus.SUCCESS.status, "添加成功.");
    }

    @Override
    public Result<User> deleteRoleById(int rid) {
        roleDao.deleteRoleById(rid);
        return new Result<User>(Result.ResultStatus.SUCCESS.status, "删除成功.");
    }

    @Override
    public Role findRoleByRid(int rid) {
        Role role=roleDao.findRoleByRid(rid);
        return role;
    }
}
