package com.bangduoduo.web.service;

import com.bangduoduo.web.domain.Article;
import com.bangduoduo.web.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public void addArticle(Article article) {
        this.articleMapper.addArticle(article);
    }
}
