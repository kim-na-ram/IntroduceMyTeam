package com.bootcamp.introductmyteam.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CommentResponses {
    private List<CommentResponse> commentResponses;

    public static CommentResponses of(List<CommentResponse> commentResponses) {
        return new CommentResponses(commentResponses);
    }
}
