package com.huangjn.blogbackstage.modules.content.dao;

import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import com.huangjn.blogbackstage.modules.content.pojo.Software;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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
}
