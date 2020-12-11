package com.huangjn.blogbackstage.modules.content.service;

import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.common.vo.Result;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import com.huangjn.blogbackstage.modules.content.pojo.Photo;

public interface PhotoService {
    PageInfo<Photo> findAllPhoto(SearchVo searchVo);

    Result<Object> insertPhoto(Photo photo);

    Result<Object> deletePhotoById(int photoId);

    Photo findPhotoByPid(int photoId);

    Result<Object> editPhoto(Photo photo);
}
