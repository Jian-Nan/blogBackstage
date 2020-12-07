package com.huangjn.blogbackstage.modules.content.controller;

import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import com.huangjn.blogbackstage.modules.content.pojo.Article;
import com.huangjn.blogbackstage.modules.content.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/findAllArticle")
    PageInfo<Article> findAllArticle(@RequestBody SearchVo searchVo )
    {
        return articleService.findAllArticle(searchVo);
    }

}
