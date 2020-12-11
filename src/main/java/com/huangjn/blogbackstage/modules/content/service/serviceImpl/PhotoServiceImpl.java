package com.huangjn.blogbackstage.modules.content.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.common.vo.Result;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import com.huangjn.blogbackstage.modules.content.dao.PhotoDao;
import com.huangjn.blogbackstage.modules.content.pojo.Photo;
import com.huangjn.blogbackstage.modules.content.pojo.Software;
import com.huangjn.blogbackstage.modules.content.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoDao photoDao;

    @Override
    public PageInfo<Photo> findAllPhoto(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<Photo>(
                Optional.ofNullable(photoDao.findAllPhoto(searchVo))
                        .orElse(Collections.emptyList()));
    }

    @Override
    public Result<Object> insertPhoto(Photo photo) {
        Date date = new Date();
        photo.setPhotoDate(date);
        photoDao.insertPhoto(photo);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "添加成功.");
    }

    @Override
    public Result<Object> deletePhotoById(int photoId) {
        photoDao.deletePhotoById(photoId);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "删除成功.");
    }

    @Override
    public Photo findPhotoByPid(int photoId) {
        return photoDao.findPhotoByPid(photoId);
    }

    @Override
    public Result<Object> editPhoto(Photo photo) {
        Date date = new Date();
        photo.setPhotoDate(date);
        photoDao.editPhoto(photo);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "编辑成功.");
    }
}
