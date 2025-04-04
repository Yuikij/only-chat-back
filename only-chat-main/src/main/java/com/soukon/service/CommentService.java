package com.soukon.service;


import com.soukon.domain.CommentDTO;

import java.util.List;

public interface CommentService {
    CommentDTO createComment(CommentDTO commentDTO);
    
    CommentDTO updateComment(CommentDTO commentDTO);
    
    void deleteComment(Long id);
    
    CommentDTO getComment(Long id);
    
    List<CommentDTO> listComments();
}