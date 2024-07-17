package com.bootcamp.introductmyteam.dto.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest {
    String nickname;
    String password;
    String contents;
}
