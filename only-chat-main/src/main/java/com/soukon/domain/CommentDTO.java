package com.soukon.domain;

import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    private String domPath;
    private String text;
    private String url;
    private String comment;
    private String color;
    private String originalText;
}