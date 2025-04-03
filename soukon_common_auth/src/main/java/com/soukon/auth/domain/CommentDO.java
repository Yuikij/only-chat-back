package com.soukon.auth.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("comment")
public class CommentDO {
    @TableId
    private Long id;
    
    private String domPath;
    
    private String text;
    
    private String url;
    
    private String comment;
    
    private String color;
    
    private String originalText;
}