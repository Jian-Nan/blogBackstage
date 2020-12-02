package com.huangjn.blogbackstage.modules.account.controller;


import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.account.pojo.Role;
import com.huangjn.blogbackstage.modules.account.pojo.User;
import com.huangjn.blogbackstage.modules.account.service.RoleService;
import com.huangjn.blogbackstage.modules.common.vo.Result;
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

    @PostMapping("/insertRole")
    Result<User> insertRole(@RequestBody String roleName) {
        return roleService.insertRole(roleName);
    }

    @DeleteMapping("/deleteRoleById/{rid}")
    Result<User> deleteRoleById(@PathVariable int rid) {
        return roleService.deleteRoleById(rid);
    }

    @GetMapping("/findRoleByRid/{rid}")
    Role findUserByUid(@PathVariable int rid) {
        return roleService.findRoleByRid(rid);
    }
}
