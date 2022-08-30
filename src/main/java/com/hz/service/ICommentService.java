package com.hz.service;

import com.hz.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import javax.annotation.security.PermitAll;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
public interface ICommentService  {

    List<Comment> getComment(@Param("productid")Integer productid);
    boolean updateComment(@Param("comment")Comment comment);
    boolean InsertComment(@Param("comment")Comment comment);
    boolean deleteComment(@Param("commentid")Integer commentId);
}
