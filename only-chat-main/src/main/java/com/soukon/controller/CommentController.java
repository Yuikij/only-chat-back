package com.soukon.controller;


import com.soukon.core.http.ApiResponse;
import com.soukon.domain.CommentDTO;
import com.soukon.service.CommentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    
    @Resource
    private CommentService commentService;

    @PostMapping
    public ApiResponse<CommentDTO> createComment(@RequestBody CommentDTO commentDTO) {
        return ApiResponse.success(commentService.createComment(commentDTO));
    }

    @PutMapping
    public ApiResponse<CommentDTO> updateComment(@RequestBody CommentDTO commentDTO) {
        return ApiResponse.success(commentService.updateComment(commentDTO));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ApiResponse.success();
    }

    @GetMapping("/{id}")
    public ApiResponse<CommentDTO> getComment(@PathVariable Long id) {
        return ApiResponse.success(commentService.getComment(id));
    }

    @GetMapping
    public ApiResponse<List<CommentDTO>> listComments() {
        return ApiResponse.success(commentService.listComments());
    }
}