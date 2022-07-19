package com.example.sbb.article.service;

import com.example.sbb.article.dao.ArticleRepository;
import com.example.sbb.article.domain.Article;
import com.example.sbb.util.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getList() {
        return articleRepository.findAll();
    }

    public Article getArticle(Integer id) {
        Optional<Article> opArticle = this.articleRepository.findById(id);
        if (opArticle.isPresent()) {
            Article article = opArticle.get();
            article.setViewCount(article.getViewCount() + 1);
            this.articleRepository.save(article);
            return article;
        } else {
            throw new DataNotFoundException("article not found");
        }
    }
}