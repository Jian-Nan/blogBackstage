package com.huangjn.blogbackstage.modules.account.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.account.dao.PermissionDao;
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
        String permissionName = "";
        List<Role> roles=permission.getRoles();
        if(roles!=null)
        {
            permissionName+= roles.get(0).getRoleName();
        }
        for(int i=1;i<roles.size();i++)
        {
            permissionName+= ","+roles.get(i).getRoleName();
        }
        permission.setPermissionName(permissionName);
        permissionDao.insertPermission(permission);
        return new Result<Permission>(Result.ResultStatus.SUCCESS.status, "添加成功.");
    }
}
