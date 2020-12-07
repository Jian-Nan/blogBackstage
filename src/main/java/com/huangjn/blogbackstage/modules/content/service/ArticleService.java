package com.huangjn.blogbackstage.modules.content.service;

import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import com.huangjn.blogbackstage.modules.content.pojo.Article;

public interface ArticleService {
    PageInfo<Article> findAllArticle(SearchVo searchVo);
}
