package com.soukon.auth.controller;

import com.soukon.auth.domain.CommentDTO;
import com.soukon.auth.service.CommentService;
import com.soukon.core.http.ApiResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    
    @Resource
    private CommentService commentService;

    @PostMapping
    public ApiResponse<CommentDTO> createComment(@RequestBody CommentDTO commentDTO) {
        return ApiResponse.ok(commentService.createComment(commentDTO));
    }

    @PutMapping
    public ApiResponse<CommentDTO> updateComment(@RequestBody CommentDTO commentDTO) {
        return ApiResponse.ok(commentService.updateComment(commentDTO));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ApiResponse.ok();
    }

    @GetMapping("/{id}")
    public ApiResponse<CommentDTO> getComment(@PathVariable Long id) {
        return ApiResponse.ok(commentService.getComment(id));
    }

    @GetMapping
    public ApiResponse<List<CommentDTO>> listComments() {
        return ApiResponse.ok(commentService.listComments());
    }
}