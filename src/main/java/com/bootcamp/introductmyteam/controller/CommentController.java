package com.bootcamp.introductmyteam.controller;

import com.bootcamp.introductmyteam.dto.response.CommentResponse;
import com.bootcamp.introductmyteam.dto.response.CommentResponses;
import com.bootcamp.introductmyteam.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/comments")
@RestController
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{articleId}")
    public ResponseEntity<CommentResponses> getComments(@PathVariable Long articleId) {
        List<CommentResponse> commentResponses = commentService.findByArticleId(articleId);
        return ResponseEntity.ok(CommentResponses.of(commentResponses));
    }
}
