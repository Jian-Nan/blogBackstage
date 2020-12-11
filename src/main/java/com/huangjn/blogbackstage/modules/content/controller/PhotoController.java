package com.huangjn.blogbackstage.modules.content.controller;

import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.common.vo.Result;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import com.huangjn.blogbackstage.modules.content.pojo.Photo;
import com.huangjn.blogbackstage.modules.content.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api")
public class PhotoController {

    @Autowired
    private  PhotoService photoService;

    @PostMapping("/findAllPhoto")
    PageInfo<Photo> findAllPhoto(@RequestBody SearchVo searchVo)
    {
        return photoService.findAllPhoto(searchVo);
    }

    @PostMapping("/insertPhoto")
    Result<Object> insertPhoto(@RequestBody Photo photo){
        return photoService.insertPhoto(photo);
    }

    @DeleteMapping("/deletePhotoById/{photoId}")
    Result<Object> deletePhotoById(@PathVariable int photoId)
    {
        return photoService.deletePhotoById(photoId);
    }

    @GetMapping("/findPhotoByPid/{photoId}")
    Photo findPhotoByPid(@PathVariable int photoId){
        return photoService.findPhotoByPid(photoId);
    }

    @PostMapping("/editPhoto")
    Result<Object> editPhoto(@RequestBody Photo photo){
        return photoService.editPhoto(photo);
    }
}
