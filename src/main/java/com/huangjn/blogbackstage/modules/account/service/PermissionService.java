package com.huangjn.blogbackstage.modules.account.service;

import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.account.pojo.Permission;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;

public interface PermissionService {
    PageInfo<Permission> findAllPermission(SearchVo searchVo);
}
