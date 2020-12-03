package com.huangjn.blogbackstage.modules.account.controller;


import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.account.pojo.Permission;
import com.huangjn.blogbackstage.modules.account.service.PermissionService;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @PostMapping("/findAllPermission")
    PageInfo<Permission>findAllPermission(@RequestBody SearchVo searchVo){
        return permissionService.findAllPermission(searchVo);
    }
}
