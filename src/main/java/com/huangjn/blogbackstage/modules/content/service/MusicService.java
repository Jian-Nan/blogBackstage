package com.huangjn.blogbackstage.modules.content.service;

import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.common.vo.Result;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import com.huangjn.blogbackstage.modules.content.pojo.Music;

public interface MusicService {
    PageInfo<Music> findAllMusic(SearchVo searchVo);

    Result<Object> insertMusic(Music music);

    Result<Object> deleteMusicById(int musicId);

    Music findMusicByMid(int musicId);

    Result<Object> editMusic(Music music);
}
