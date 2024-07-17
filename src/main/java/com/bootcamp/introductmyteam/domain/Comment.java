package com.bootcamp.introductmyteam.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Comment {

    @GeneratedValue
    @Id
    private Long id;

    private String content;

    private String nickname;

    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;

    protected Comment() {}

    @Builder
    private Comment(String content, String nickname, String password, Article article) {
        this.content = content;
        this.nickname = nickname;
        this.password = password;
        this.article = article;
    }

    public static Comment of(String content, String nickname, String password, Article article) {
        return new Comment(content, nickname, password, article);
    }
}