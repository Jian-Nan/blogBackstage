package com.huangjn.blogbackstage.modules.content.dao;

import com.huangjn.blogbackstage.modules.content.pojo.SoftwareContent;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SoftwareContentDao {
    @Insert("insert into softwareContent(s_id,softwareContent,link) values(#{sid},#{softwareContent},#{link})")
    void insertSoftwareContent(SoftwareContent softwareContent);

    @Delete("delete from softwareContent  where s_id=#{softwareId}")
    void deleteSoftwareContentById(int softwareId);

    @Select("select softwareContent,link from softwareContent where s_id=#{softwareId}")
    SoftwareContent findSoftwareContentBySid(int softwareId);

    @Update("update softwareContent set softwareContent=#{softwareContent},link=#{link} where s_id=#{sid}")
    void editSoftwareContent(SoftwareContent softwareContent);
}
