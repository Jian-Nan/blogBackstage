package com.huangjn.blogbackstage.modules.account.controller;


import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.account.pojo.Role;
import com.huangjn.blogbackstage.modules.account.service.RoleService;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/roles")
    List<Role> getRoles() {
        return roleService.getRoles();
    }

    @PostMapping("/findAllRoles")
    PageInfo<Role> findAllRoles(@RequestBody SearchVo searchVo)
    {
        return roleService.findAllRoles(searchVo);
    }
}
