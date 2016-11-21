package com.bangduoduo.monkey.model.controller;

import com.bangduoduo.monkey.model.domain.Article;
import com.bangduoduo.monkey.model.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.HtmlUtils;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String initForm(ModelMap model) {
        Article article = new Article();
        //在进入表单页面的时候，要先初始化一个Article对象给表单
        model.addAttribute("article", article);
        return "article_add";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String addArticle(@Valid Article article, BindingResult result, ModelMap model) {
        if(result.hasErrors()) {
            return "article_add";
        }
        article.setContent(HtmlUtils.htmlEscape(article.getContent(), "UTF-8"));
        articleService.addArticle(article);
        return "demo";
    }

    /*
    可以用来初始化一些东西
     */
    @ModelAttribute("categories")
    public List<Integer> initializeCategories() {
        List<Integer> list = new ArrayList();
        list.add(1);
        return list;
    }
}
