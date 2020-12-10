package com.huangjn.blogbackstage.modules.content.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import com.huangjn.blogbackstage.modules.content.dao.SoftwareDao;
import com.huangjn.blogbackstage.modules.content.pojo.Software;
import com.huangjn.blogbackstage.modules.content.service.SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class SoftwareServiceImpl implements SoftwareService {

    @Autowired
    private SoftwareDao softwareDao;

    @Override
    public PageInfo<Software> findAllSoftware(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<Software>(
                Optional.ofNullable(softwareDao.findAllSoftware(searchVo))
                        .orElse(Collections.emptyList()));
    }
}
