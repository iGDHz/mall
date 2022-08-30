package com.hz.mapper;

import com.hz.pojo.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
@Mapper
public interface CommentMapper {
    List<Comment> getComment(@Param("productid")Integer productid);
    Integer updateComment(@Param("comment")Comment comment);
    Integer InsertComment(@Param("comment")Comment comment);
    Integer deleteComment(@Param("commentid")Integer commentId);
}
