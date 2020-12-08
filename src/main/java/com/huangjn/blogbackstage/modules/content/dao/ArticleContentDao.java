package com.huangjn.blogbackstage.modules.content.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ArticleContentDao {


    @Insert("insert into articleContent(aid,article_text) values(#{aid},#{articleText})")
    void insertArticleContent(int aid, String articleText);

    @Delete("delete from articleContent where aid=#{aid} ")
    void deleteArticleContentById(int aid);
}
