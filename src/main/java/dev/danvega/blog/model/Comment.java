package dev.danvega.blog.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Data;

@Data
public final class Comment {

    private String name;
    private String content;
    private LocalDateTime publishedOn;
    private LocalDateTime updatedOn;
    @Transient
    Post post;

    public Comment(String name, String content) {
        this.name = name;
        this.content = content;
        this.publishedOn = LocalDateTime.now();
    }

    @PersistenceCreator
    @JsonCreator
    public Comment(String name, String content, LocalDateTime publishedOn, LocalDateTime updatedOn) {
        this.name = name;
        this.content = content;
        this.publishedOn = publishedOn;
        this.updatedOn = updatedOn;
    }
}
