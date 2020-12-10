package com.huangjn.blogbackstage.modules.content.dao;

import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import com.huangjn.blogbackstage.modules.content.pojo.Software;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Mapper
public interface SoftwareDao {

    @Select("<script>"+
            "select  softwareId,softwareName,softwareLabel,softwarePhoto,createTime from  software" +
            "<where> " +
            "<if test='keyWord != \"\" and keyWord != null'>" +
            " and (softwareName like '%${keyWord}%') or (softwareLabel like '%${keyWord}%')" +
            "</if>" +
            "</where>" +
            "<choose>" +
            "<when test='orderBy != \"\" and orderBy != null'>" +
            " order by ${orderBy} ${sort}" +
            "</when>" +
            "<otherwise>" +
            " order by softwareId desc" +
            "</otherwise>" +
            "</choose>"+
            "</script>"
    )
    List<Software> findAllSoftware(SearchVo searchVo);

    @Insert("insert into software(softwareName,softwareLabel,softwarePhoto,createTime) values(#{softwareName},#{softwareLabel},#{softwarePhoto},#{createTime})")
    @Options(useGeneratedKeys = true, keyColumn = "softwareId", keyProperty = "softwareId")
    void insertSoftware(Software software);


    @Delete("delete from software where softwareId=#{softwareId}")
    void deleteSoftwareById(int softwareId);

    @Select("select softwareName,softwareLabel,softwarePhoto from software where softwareId=#{softwareId}")
    Software findSoftwareBySid(int softwareId);

    @Update("update software set softwareName=#{softwareName},softwareLabel=#{softwareLabel},softwarePhoto=#{softwarePhoto} where softwareId=#{softwareId}")
    void editSoftware(Software software);
}
