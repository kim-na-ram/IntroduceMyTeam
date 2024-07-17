package com.bootcamp.introductmyteam.service;

import com.bootcamp.introductmyteam.dto.response.CommentResponse;
import com.bootcamp.introductmyteam.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public List<CommentResponse> findByArticleId(Long articleId) {
        return commentRepository.findByArticleIdOrderByIdDesc(articleId).stream().map(CommentResponse::from).toList();
    }

}
