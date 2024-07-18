package com.bootcamp.introductmyteam.service;

import com.bootcamp.introductmyteam.domain.Article;
import com.bootcamp.introductmyteam.domain.Comment;
import com.bootcamp.introductmyteam.dto.request.CommentDeleteRequest;
import com.bootcamp.introductmyteam.dto.request.CommentRequest;
import com.bootcamp.introductmyteam.domain.Comment;
import com.bootcamp.introductmyteam.dto.request.CommentUpdateRequest;
import com.bootcamp.introductmyteam.dto.response.CommentResponse;
import com.bootcamp.introductmyteam.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public long saveComment(Long articleId, CommentRequest commentRequest) {
        Article article = Article.builder()
                .id(articleId)
                .build();

        Comment comment = Comment.builder()
                .nickname(commentRequest.getNickname())
                .password(commentRequest.getPassword())
                .content(commentRequest.getContents())
                .article(article)
                .build();

        log.info("comment = {}", comment.getNickname());

        return commentRepository.save(comment).getId();
    }

    @Transactional(readOnly = true)
    public List<CommentResponse> findByArticleId(Long articleId) {
        return commentRepository.findByArticleIdOrderByIdDesc(articleId).stream().map(CommentResponse::from).toList();
    }

    @Transactional
    public void updateComment(Long commentId, CommentUpdateRequest commentUpdateRequest) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(RuntimeException::new);
        validateAuthor(comment, commentUpdateRequest.getPassword());
        comment.updateContent(commentUpdateRequest.getContent());
    }

    @Transactional
    public boolean deleteComment(Long commentId, CommentDeleteRequest deleteRequest) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(RuntimeException::new);
        if(validateAuthor(comment, deleteRequest.getPassword())) {
            commentRepository.delete(comment);
            return true;
        } else
            return false;
    }

    private boolean validateAuthor(Comment comment, String password) {
        return comment.getPassword().equals(password);
    }


}
