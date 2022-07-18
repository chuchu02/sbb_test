package com.example.sbb.reply.controller;

import com.example.sbb.article.domain.Article;
import com.example.sbb.article.service.ArticleService;
import com.example.sbb.reply.service.ReplyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reply")
@AllArgsConstructor
public class ReplyController {
    private final ArticleService articleService;
    private final ReplyService replyService;

    @PostMapping("/create/{id}")
    public String createReply(Model model, @PathVariable("id") Integer id, @RequestParam String content) {
        Article article = this.articleService.getArticle(id);
        this.replyService.create(article, content);
        return String.format("redirect:/article/detail/%s", id);
    }
}