package com.bootcamp.introductmyteam.controller;

import com.bootcamp.introductmyteam.dto.request.CommentDeleteRequest;
import com.bootcamp.introductmyteam.dto.request.CommentRequest;
import com.bootcamp.introductmyteam.dto.request.CommentUpdateRequest;
import com.bootcamp.introductmyteam.dto.response.CommentResponse;
import com.bootcamp.introductmyteam.dto.response.CommentResponses;
import com.bootcamp.introductmyteam.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public ResponseEntity<CommentResponses> getComments(@PathVariable Long articleId) {
        List<CommentResponse> commentResponses = commentService.findByArticleId(articleId);
        return ResponseEntity.ok(CommentResponses.of(commentResponses));
    }

    @PutMapping("/{commentId}")
    @ResponseBody
    public ResponseEntity<Void> updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest request) {
        commentService.updateComment(commentId, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{commentId}")
    @ResponseBody
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId, @RequestBody CommentDeleteRequest deleteRequest) {
        commentService.deleteComment(commentId, deleteRequest);
        return ResponseEntity.noContent().build();
    }
}
