package com.bootcamp.introductmyteam.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Article {

    @GeneratedValue
    @Id
    private Long id;

    @Builder
    private Article(Long id) {
        this.id = id;
    }
}
