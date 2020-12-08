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

import java.text.SimpleDateFormat;
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
}
