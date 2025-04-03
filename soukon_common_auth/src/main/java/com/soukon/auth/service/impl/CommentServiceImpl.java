package com.soukon.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.soukon.auth.domain.CommentDO;
import com.soukon.auth.domain.CommentDTO;
import com.soukon.auth.mapper.CommentMapper;
import com.soukon.auth.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    
    @Resource
    private CommentMapper commentMapper;

    @Override
    public CommentDTO createComment(CommentDTO commentDTO) {
        CommentDO commentDO = new CommentDO();
        BeanUtils.copyProperties(commentDTO, commentDO);
        commentMapper.insert(commentDO);
        commentDTO.setId(commentDO.getId());
        return commentDTO;
    }

    @Override
    public CommentDTO updateComment(CommentDTO commentDTO) {
        CommentDO commentDO = new CommentDO();
        BeanUtils.copyProperties(commentDTO, commentDO);
        commentMapper.updateById(commentDO);
        return commentDTO;
    }

    @Override
    public void deleteComment(Long id) {
        commentMapper.deleteById(id);
    }

    @Override
    public CommentDTO getComment(Long id) {
        CommentDO commentDO = commentMapper.selectById(id);
        if (commentDO == null) {
            return null;
        }
        CommentDTO commentDTO = new CommentDTO();
        BeanUtils.copyProperties(commentDO, commentDTO);
        return commentDTO;
    }

    @Override
    public List<CommentDTO> listComments() {
        List<CommentDO> commentDOS = commentMapper.selectList(new QueryWrapper<>());
        return commentDOS.stream()
                .map(commentDO -> {
                    CommentDTO commentDTO = new CommentDTO();
                    BeanUtils.copyProperties(commentDO, commentDTO);
                    return commentDTO;
                })
                .collect(Collectors.toList());
    }
}