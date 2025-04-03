package com.soukon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.soukon.domain.CommentDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends BaseMapper<CommentDO> {
}