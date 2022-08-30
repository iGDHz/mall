package com.hz.service.impl;

import com.hz.pojo.Comment;
import com.hz.mapper.CommentMapper;
import com.hz.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> getComment(Integer productid) {
        return commentMapper.getComment(productid);
    }

    @Override
    public boolean updateComment(Comment comment) {
        return commentMapper.updateComment(comment)>0;
    }
    @Override
    public boolean InsertComment(Comment comment) {
        return commentMapper.InsertComment(comment)>0;
    }

    @Override
    public boolean deleteComment(Integer commentId) {
        return commentMapper.deleteComment(commentId)>0;
    }
}
