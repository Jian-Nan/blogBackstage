package com.huangjn.blogbackstage.modules.content.dao;


import com.huangjn.blogbackstage.modules.common.vo.Result;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import com.huangjn.blogbackstage.modules.content.pojo.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@Mapper
public interface ArticleDao {
    @Select("<script>"+
            "select article_id as aid, articleTitle, articlePhoto, createTime, articleLabel, visitNumber, articleAuthor from  article" +
            "<where> " +
            "<if test='keyWord != \"\" and keyWord != null'>" +
            " and (articleTitle like '%${keyWord}%') or (articleLabel like '%${keyWord}%')" +
            "</if>" +
            "</where>" +
            "<choose>" +
            "<when test='orderBy != \"\" and orderBy != null'>" +
            " order by ${orderBy} ${sort}" +
            "</when>" +
            "<otherwise>" +
            " order by aid desc" +
            "</otherwise>" +
            "</choose>"+
            "</script>"
    )
    List<Article> findAllAdministrators(SearchVo searchVo);

    @Insert("insert into article (article_id, articleTitle,articlePhoto, createTime, articleLabel,visitNumber,articleAuthor) " +
            "values (#{aid}, #{articleTitle}, #{articlePhoto}, #{createTime},#{articleLabel},#{visitNumber},#{articleAuthor})")
    @Options(useGeneratedKeys = true, keyColumn = "article_id", keyProperty = "aid")
    void insertArticle(Article article);

    @Delete("delete from article where article_id=#{aid}")
    void deleteArticleById(int aid);

    @Select("select article_id as aid, articleTitle, articlePhoto,articleLabel, articleAuthor from article where article_id=#{aid}")
    Article findArticleByAid(int aid);

    @Update("update article set articleTitle=#{articleTitle},articlePhoto=#{articlePhoto},articleLabel=#{articleLabel},articleAuthor=#{articleAuthor} where article_id=#{aid}")
    void editArticle(Article article);
}
