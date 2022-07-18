package com.example.sbb.article.controller;

import com.example.sbb.article.domain.Article;
import com.example.sbb.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;


    @RequestMapping("/list")
    public String showList(Model model) {
        List<Article> articleList =  articleService.getList();
        model.addAttribute("articleList", articleList);
        return "article_list";
    }

    @RequestMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);

        return "article_detail";
    }
}
