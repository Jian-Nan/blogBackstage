package com.huangjn.blogbackstage.modules.content.dao;

import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import com.huangjn.blogbackstage.modules.content.pojo.Photo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PhotoDao {

    @Select("<script>"+
            "select photoId, photoName, photoContent, photoUrl, photoDate from  photo" +
            "<where> " +
            "<if test='keyWord != \"\" and keyWord != null'>" +
            " and (photoName like '%${keyWord}%')" +
            "</if>" +
            "</where>" +
            "<choose>" +
            "<when test='orderBy != \"\" and orderBy != null'>" +
            " order by ${orderBy} ${sort}" +
            "</when>" +
            "<otherwise>" +
            " order by photoId desc" +
            "</otherwise>" +
            "</choose>"+
            "</script>"
    )
    List<Photo> findAllPhoto(SearchVo searchVo);

    @Insert("insert into photo(photoName,photoContent,photoUrl,photoDate) values(#{photoName},#{photoContent},#{photoUrl},#{photoDate})")
    void insertPhoto(Photo photo);

    @Delete("delete from photo where photoId=#{photoId} ")
    void deletePhotoById(int photoId);

    @Select("select photoName, photoContent, photoUrl, photoDate from photo where photoId=#{photoId}")
    Photo findPhotoByPid(int photoId);

    @Update("update photo set photoName=#{photoName},photoContent=#{photoContent},photoUrl=#{photoUrl},photoDate=#{photoDate} where photoId=#{photoId}")
    void editPhoto(Photo photo);
}
