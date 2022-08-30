package com.hz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
@TableName("comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论id
     */
    @TableId(value = "CommentId", type = IdType.AUTO)
    private Integer commentId;

    /**
     * 评论信息
     */
    @TableField(value = "CommentDetail")
    private String commentDetail;

    /**
     * 商品id
     */
    @TableField(value = "ProductId")
    private Integer productId;

    /**
     * 评论点赞数
     */
    @TableField(value = "CommentPraise")
    private Integer commentPraise;

    /**
     * 评论回复
     */
    @TableField(value = "CommentReturnId")
    private Integer commentReturnId;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
    public String getCommentDetail() {
        return commentDetail;
    }

    public void setCommentDetail(String commentDetail) {
        this.commentDetail = commentDetail;
    }
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public Integer getCommentPraise() {
        return commentPraise;
    }

    public void setCommentPraise(Integer commentPraise) {
        this.commentPraise = commentPraise;
    }
    public Integer getCommentReturnId() {
        return commentReturnId;
    }

    public void setCommentReturnId(Integer commentReturnId) {
        this.commentReturnId = commentReturnId;
    }

    @Override
    public String toString() {
        return "Comment{" +
            "commentId=" + commentId +
            ", commentDetail=" + commentDetail +
            ", productId=" + productId +
            ", commentPraise=" + commentPraise +
            ", commentReturnId=" + commentReturnId +
        "}";
    }
}
