package com.bootcamp.introductmyteam.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Article {

    @GeneratedValue
    @Id
    private Long id;
}
