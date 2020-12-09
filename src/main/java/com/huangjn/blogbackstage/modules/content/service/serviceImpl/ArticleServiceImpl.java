package com.huangjn.blogbackstage.modules.content.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.common.vo.Result;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import com.huangjn.blogbackstage.modules.content.dao.ArticleContentDao;
import com.huangjn.blogbackstage.modules.content.dao.ArticleDao;
import com.huangjn.blogbackstage.modules.content.pojo.Article;
import com.huangjn.blogbackstage.modules.content.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ArticleContentDao articleContentDao;

    @Override
    public PageInfo<Article> findAllArticle(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<Article>(
                Optional.ofNullable(articleDao.findAllAdministrators(searchVo))
                        .orElse(Collections.emptyList()));
    }

    @Override
    public Result<Object> insertArticle(@RequestBody  Article article) {
        String time = null;
        Date date = new Date();
        article.setVisitNumber(1);
        article.setCreateTime(date);
        articleDao.insertArticle(article);
        articleContentDao.insertArticleContent(article.getAid(),article.getArticleText());
        return new Result<>(Result.ResultStatus.SUCCESS.status, "添加成功.");
    }

    @Override
    public Result<Object> deleteArticleById(int aid) {
        articleDao.deleteArticleById(aid);
        articleContentDao.deleteArticleContentById(aid);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "删除成功.");
    }

    @Override
    public Article findArticleByAid(int aid) {
        Article article=articleDao.findArticleByAid(aid);
        String setArticleText=articleContentDao.findArticleContentByAid(aid);
        article.setArticleText(setArticleText);
        return article;
    }

    @Override
    public Result<Object> editArticle(Article article) {
        articleDao.editArticle(article);
        String ArticleText=articleContentDao.findArticleContentByAid(article.getAid());
        if(ArticleText==null)
        {
            articleContentDao.insertArticleContent(article.getAid(),article.getArticleText());
            return new Result<>(Result.ResultStatus.SUCCESS.status, "编辑成功.");
        }
        articleContentDao.editArticleContent(article.getAid(),article.getArticleText());
        return new Result<>(Result.ResultStatus.SUCCESS.status, "编辑成功.");
    }
}
