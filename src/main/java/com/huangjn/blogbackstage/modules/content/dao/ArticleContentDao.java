package com.huangjn.blogbackstage.modules.content.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ArticleContentDao {


    @Insert("insert into articleContent(aid,article_text) values(#{aid},#{articleText})")
    void insertArticleContent(int aid, String articleText);

    @Delete("delete from articleContent where aid=#{aid} ")
    void deleteArticleContentById(int aid);

    @Select("select article_text from articleContent where aid=#{aid}")
    String findArticleContentByAid(int aid);

    @Update("update articleContent set article_text=#{articleText} where aid=#{aid}")
    void editArticleContent(int aid, String articleText);
}
