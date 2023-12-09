package com.cody.controller;

import com.cody.pojo.Article;
import com.cody.repository.ArticleRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    // Get all articles
    @GetMapping
    public Iterable<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    // Get a single article
    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        Optional<Article> article = Optional.ofNullable(articleRepository.findOne(id));
        return article.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new article
    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        Article savedArticle = articleRepository.save(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

//    // Update an existing article
//    @PutMapping("/{id}")
//    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article updatedArticle) {
//        if (!articleRepository.existsById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//
//        updatedArticle.setArticleId(id);
//        Article savedArticle = articleRepository.save(updatedArticle);
//        return ResponseEntity.ok(savedArticle);
//    }
//
//    // Delete an article
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
//        if (!articleRepository.existsById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//
//        articleRepository.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
}