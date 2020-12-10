package com.huangjn.blogbackstage.modules.content.service;

import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.common.vo.Result;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import com.huangjn.blogbackstage.modules.content.pojo.Software;

public interface SoftwareService {
    PageInfo<Software> findAllSoftware(SearchVo searchVo);

    Result<Object> insertSoftware(Software software);

    Result<Object> deleteSoftwareById(int softwareId);
}
