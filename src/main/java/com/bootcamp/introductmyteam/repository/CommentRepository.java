package com.bootcamp.introductmyteam.repository;

import com.bootcamp.introductmyteam.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c WHERE c.article.id = :articleId ORDER BY c.id DESC")
    List<Comment> findByArticleIdOrderByIdDesc(@Param("articleId") Long articleId);
}
