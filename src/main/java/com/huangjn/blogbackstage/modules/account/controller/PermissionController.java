package com.huangjn.blogbackstage.modules.account.controller;


import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.account.pojo.Permission;
import com.huangjn.blogbackstage.modules.account.service.PermissionService;
import com.huangjn.blogbackstage.modules.common.vo.Result;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @PostMapping("/findAllPermission")
    PageInfo<Permission>findAllPermission(@RequestBody SearchVo searchVo){
        return permissionService.findAllPermission(searchVo);
    }

    @PostMapping("/insertPermission")
    Result<Permission> insertPermission(@RequestBody Permission permission)
    {
        return permissionService.insertPermission(permission);
    }

    @DeleteMapping("/deletePermissionById/{pid}")
    Result<Object> deletePermissionById(@PathVariable int pid)
    {
        return permissionService.deletePermissionById(pid);
    }
    @GetMapping("/findPermissionByPid/{pid}")
    Permission findPermissionByPid(@PathVariable int pid)
    {
        return permissionService.findPermissionByPid(pid);
    }
    @PostMapping("/editPermissionRole")
    Result<Object> editPermissionRole(@RequestBody Permission permission){
        return permissionService.editPermissionRole(permission);
    }
}
