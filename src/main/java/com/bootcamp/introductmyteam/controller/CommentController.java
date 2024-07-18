package com.bootcamp.introductmyteam.controller;

import com.bootcamp.introductmyteam.dto.request.CommentDeleteRequest;
import com.bootcamp.introductmyteam.dto.request.CommentRequest;
import com.bootcamp.introductmyteam.dto.request.CommentUpdateRequest;
import com.bootcamp.introductmyteam.dto.response.CommentResponse;
import com.bootcamp.introductmyteam.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/comments")
@Controller
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{articleId}")
    public String registerComment(@PathVariable("articleId") Long articleId, CommentRequest commentRequest) {
        log.info("contents = {}", commentRequest.getContents());
        log.info("articleId = {}", articleId);
        commentService.saveComment(articleId, commentRequest);

        return "redirect:/comments/{articleId}";
    }

    @GetMapping("/{articleId}")
    public String getComments(@PathVariable("articleId") Long articleId, Model model) {
        List<CommentResponse> commentResponses = commentService.findByArticleId(articleId);
        log.info("comments = {}", commentResponses);

        model.addAttribute("comments", commentResponses);
        model.addAttribute("articleId", articleId);
        return "/comments";
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
