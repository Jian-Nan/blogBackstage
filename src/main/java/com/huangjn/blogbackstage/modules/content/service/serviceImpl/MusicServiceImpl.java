package com.huangjn.blogbackstage.modules.content.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.common.vo.Result;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import com.huangjn.blogbackstage.modules.content.dao.MusicDao;
import com.huangjn.blogbackstage.modules.content.pojo.Music;
import com.huangjn.blogbackstage.modules.content.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicDao musicDao;


    @Override
    public PageInfo<Music> findAllMusic(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<Music>(
                Optional.ofNullable(musicDao.findAllMusic(searchVo))
                        .orElse(Collections.emptyList()));
    }

    @Override
    public Result<Object> insertMusic(Music music) {
        musicDao.insertMusic(music);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "添加成功.");
    }

    @Override
    public Result<Object> deleteMusicById(int musicId) {
        musicDao.deleteMusicById(musicId);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "删除成功.");
    }

    @Override
    public Music findMusicByMid(int musicId) {
        return musicDao.findMusicByMid(musicId);
    }

    @Override
    public Result<Object> editMusic(Music music) {
        musicDao.editMusic(music);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "编辑成功.");
    }
}
