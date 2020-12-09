package com.huangjn.blogbackstage.modules.content.controller;

import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.common.vo.Result;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import com.huangjn.blogbackstage.modules.content.pojo.Article;
import com.huangjn.blogbackstage.modules.content.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/insertArticle")
    Result<Object> insertArticle(@RequestBody Article article){
        return articleService.insertArticle(article);
    }

    @DeleteMapping("/deleteArticleById/{aid}")
    Result<Object> deleteArticleById(@PathVariable int aid) {
        return articleService.deleteArticleById(aid);
    }

    @GetMapping("/findArticleByAid/{aid}")
    Article findArticleByAid(@PathVariable int aid)
    {
        return  articleService.findArticleByAid(aid);
    }
    @PostMapping("/editArticle")
    Result<Object> editArticle(@RequestBody Article article){
        return articleService.editArticle(article);
    }

}
