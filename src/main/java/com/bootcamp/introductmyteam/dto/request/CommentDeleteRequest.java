package com.bootcamp.introductmyteam.dto.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CommentDeleteRequest {
    private String password;
}
