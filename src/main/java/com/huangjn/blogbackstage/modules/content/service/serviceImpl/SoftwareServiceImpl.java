package com.huangjn.blogbackstage.modules.content.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.common.vo.Result;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import com.huangjn.blogbackstage.modules.content.dao.SoftwareContentDao;
import com.huangjn.blogbackstage.modules.content.dao.SoftwareDao;
import com.huangjn.blogbackstage.modules.content.pojo.Software;
import com.huangjn.blogbackstage.modules.content.pojo.SoftwareContent;
import com.huangjn.blogbackstage.modules.content.service.SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Service
public class SoftwareServiceImpl implements SoftwareService {

    @Autowired
    private SoftwareDao softwareDao;

    @Autowired
    private SoftwareContentDao softwareContentDao;

    @Override
    public PageInfo<Software> findAllSoftware(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<Software>(
                Optional.ofNullable(softwareDao.findAllSoftware(searchVo))
                        .orElse(Collections.emptyList()));
    }

    @Override
    public Result<Object> insertSoftware(Software software) {
        Date date = new Date();
        software.setCreateTime(date);
        softwareDao.insertSoftware(software);
        SoftwareContent softwareContent=software.getSoftwareContent();
        softwareContent.setSid(software.getSoftwareId());
        softwareContentDao.insertSoftwareContent(softwareContent);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "添加成功.");
    }

    @Override
    public Result<Object> deleteSoftwareById(int softwareId) {
        softwareDao.deleteSoftwareById(softwareId);
        softwareContentDao.deleteSoftwareContentById(softwareId);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "删除成功.");
    }

    @Override
    public Software findSoftwareBySid(int softwareId) {
        Software software=softwareDao.findSoftwareBySid(softwareId);

        SoftwareContent softwareContent=softwareContentDao.findSoftwareContentBySid(softwareId);
        if(softwareContent==null)
        {
            softwareContent=new SoftwareContent();
            softwareContent.setLink("");
            softwareContent.setSoftwareContent("");
            software.setSoftwareContent(softwareContent);
            return software;
        }
        software.setSoftwareContent(softwareContent);
        return software;
    }

    @Override
    public Result<Object> editSoftware(Software software) {
        softwareDao.editSoftware(software);
        SoftwareContent softwareContent=software.getSoftwareContent();
        softwareContent.setSid(software.getSoftwareId());
        if(softwareContentDao.findSoftwareContentBySid(softwareContent.getSid())==null)
        {
            softwareContentDao.insertSoftwareContent(softwareContent);
            return new Result<>(Result.ResultStatus.SUCCESS.status, "编辑成功.");
        }
        softwareContentDao.editSoftwareContent(softwareContent);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "编辑成功.");
    }
}
