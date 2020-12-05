package com.huangjn.blogbackstage.modules.account.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.account.dao.PermissionDao;
import com.huangjn.blogbackstage.modules.account.dao.PermissionRoleDao;
import com.huangjn.blogbackstage.modules.account.pojo.Permission;
import com.huangjn.blogbackstage.modules.account.pojo.Role;
import com.huangjn.blogbackstage.modules.account.service.PermissionService;
import com.huangjn.blogbackstage.modules.common.vo.Result;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionDao permissionDao;

    @Autowired
    PermissionRoleDao permissionRoleDao;

    @Override
    public PageInfo<Permission> findAllPermission(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<Permission>(
                Optional.ofNullable(permissionDao.getPermissionBySearchVo(searchVo))
                        .orElse(Collections.emptyList()));
    }

    @Override
    public Result<Permission> insertPermission(Permission permission) {
        String roleName = "";
        List<Role> roles=permission.getRoles();
        if(roles!=null)
        {
            roleName+= roles.get(0).getRoleName();
        }
        for(int i=1;i<roles.size();i++)
        {
            roleName+= ","+roles.get(i).getRoleName();
        }
        permission.setRoleName(roleName);
        permissionDao.insertPermission(permission);
        int pid = permission.getPid();
        for(Role r:roles)
        {
            permissionRoleDao.insertPermissionRole(pid,r.getRid());
        }
        return new Result<Permission>(Result.ResultStatus.SUCCESS.status, "添加成功.");
    }

    @Override
    public Result<Object> deletePermissionById(int pid) {
        permissionDao.deletePermissionById(pid);
        permissionRoleDao.deletePermissionById(pid);

        return new Result<Object>(Result.ResultStatus.SUCCESS.status, "删除成功.");
    }

    @Override
    public Permission findPermissionByPid(int pid) {
        Permission permission=permissionDao.findPermissionByPid(pid);
        List<Role> roles=permissionRoleDao.findPermissRoleionByPid(pid);
        permission.setRoles(roles);
        return permission;
    }

    @Override
    public Result<Object> editPermissionRole(Permission permission) {
        int pid=permission.getPid();
        String roleName = "";
        List<Role> roles=permission.getRoles();
        if(roles!=null)
        {
            roleName+= roles.get(0).getRoleName();
        }
        for(int i=1;i<roles.size();i++)
        {
            roleName+= ","+roles.get(i).getRoleName();
        }
        permission.setRoleName(roleName);
        permissionDao.updatePermission(permission);
        permissionRoleDao.deletePermissionById(pid);
        for(Role r:roles)
        {
            permissionRoleDao.insertPermissionRole(pid,r.getRid());
        }

        return new Result<Object>(Result.ResultStatus.SUCCESS.status, "修改成功.");
    }
}
