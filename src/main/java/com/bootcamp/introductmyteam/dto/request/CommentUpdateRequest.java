package com.bootcamp.introductmyteam.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CommentUpdateRequest {
    private String content;
    private String password;
}
