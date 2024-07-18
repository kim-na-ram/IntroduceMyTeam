package com.bootcamp.introductmyteam.controller;

import com.bootcamp.introductmyteam.dto.request.CommentRequest;
import com.bootcamp.introductmyteam.dto.response.CommentResponse;
import com.bootcamp.introductmyteam.dto.response.CommentResponses;
import com.bootcamp.introductmyteam.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/comments")
@Controller
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{articleId}")
    public String registerComment(@PathVariable Long articleId, CommentRequest commentRequest) {
        log.info("contents = {}", commentRequest.getContents());
        log.info("articleId = {}", articleId);
        commentService.saveComment(articleId, commentRequest);

        return "redirect:/member/comment.html";
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<CommentResponses> getComments(@PathVariable Long articleId) {
        List<CommentResponse> commentResponses = commentService.findByArticleId(articleId);
        return ResponseEntity.ok(CommentResponses.of(commentResponses));
    }
}
