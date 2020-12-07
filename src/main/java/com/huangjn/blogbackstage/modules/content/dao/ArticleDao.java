package com.huangjn.blogbackstage.modules.content.dao;


import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import com.huangjn.blogbackstage.modules.content.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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
}
