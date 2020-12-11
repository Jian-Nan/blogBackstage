package com.huangjn.blogbackstage.modules.content.dao;

import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import com.huangjn.blogbackstage.modules.content.pojo.Music;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MusicDao {


    @Select("<script>"+
            "select music_id as musicId ,musicName, musicPhoto from  musicBox" +
            "<where> " +
            "<if test='keyWord != \"\" and keyWord != null'>" +
            " and (musicName like '%${keyWord}%') " +
            "</if>" +
            "</where>" +
            "<choose>" +
            "<when test='orderBy != \"\" and orderBy != null'>" +
            " order by ${orderBy} ${sort}" +
            "</when>" +
            "<otherwise>" +
            " order by music_id desc" +
            "</otherwise>" +
            "</choose>"+
            "</script>"
    )
    List<Music> findAllMusic(SearchVo searchVo);


    @Insert("insert into musicBox(musicName,musicUrl,musicPhoto,musicContent) values(#{musicName},#{musicUrl},#{musicPhoto},#{musicContent})")
    void insertMusic(Music music);

    @Delete("delete from musicBox where music_id=#{musicId}")
    void deleteMusicById(int musicId);

    @Select("select musicName, musicUrl,musicContent,musicPhoto from musicBox where music_id=#{musicId}")
    Music findMusicByMid(int musicId);

    @Update("update musicBox set musicName=#{musicName},musicUrl=#{musicUrl},musicContent=#{musicContent},musicPhoto=#{musicPhoto} where music_id=#{musicId}")
    void editMusic(Music music);
}
