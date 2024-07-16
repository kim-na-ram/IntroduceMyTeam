package com.bootcamp.introductmyteam.dto.response;

import com.bootcamp.introductmyteam.domain.Comment;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CommentResponse {

    private Long id;

    private String content;

    private String nickname;

    public static CommentResponse from(Comment comment) {
        return new CommentResponse(comment.getId(), comment.getContent(), comment.getNickname());
    }
}
