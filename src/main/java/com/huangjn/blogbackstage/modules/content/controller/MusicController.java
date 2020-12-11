package com.huangjn.blogbackstage.modules.content.controller;

import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.common.vo.Result;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import com.huangjn.blogbackstage.modules.content.pojo.Music;
import com.huangjn.blogbackstage.modules.content.service.MusicService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @PostMapping("/findAllMusic")
    PageInfo<Music> findAllMusic(@RequestBody SearchVo searchVo)
    {
        return musicService.findAllMusic(searchVo);
    }

    @PostMapping("/insertMusic")
    Result<Object> insertMusic(@RequestBody Music music)
    {
        return musicService.insertMusic(music);
    }

    @DeleteMapping("/deleteMusicById/{musicId}")
    Result<Object>deleteMusicById(@PathVariable int musicId)
    {
        return musicService.deleteMusicById(musicId);
    }

    @GetMapping("/findMusicByMid/{musicId}")
    Music findMusicByMid(@PathVariable int musicId)
    {
        return musicService.findMusicByMid(musicId);
    }

    @PostMapping("/editMusic")
    Result<Object> editMusic(@RequestBody Music music){
        return musicService.editMusic(music);
    }
}
