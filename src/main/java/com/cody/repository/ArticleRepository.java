package com.cody.repository;

/**
 * 类功能描述
 *
 * @Author hyx
 * @Date 2023/11/21
 */
import com.cody.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticleRepository extends JpaRepository<Article, Long> {
}