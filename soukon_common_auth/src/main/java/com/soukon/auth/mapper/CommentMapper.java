package com.soukon.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soukon.auth.domain.CommentDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends BaseMapper<CommentDO> {
}