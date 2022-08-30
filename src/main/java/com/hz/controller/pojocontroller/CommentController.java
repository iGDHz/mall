package com.hz.controller.pojocontroller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hz.controller.BaseController;
import com.hz.pojo.Comment;
import com.hz.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
@RestController
public class CommentController extends BaseController {

    @Autowired
    CommentServiceImpl commentService;

    @RequestMapping(value = "/product/get/comment",method = RequestMethod.POST)
    public String getComments(@RequestParam("productid")Integer productid){
        JSONObject comments = new JSONObject();
        List<Comment> commentL = commentService.getComment(productid);
        JSONArray array = new JSONArray();
        for (Comment commentOne : commentL) {
            JSONObject comment = new JSONObject();
            comment.put("commentId",commentOne.getCommentId());
            comment.put("commentDetail",commentOne.getCommentDetail());
            comment.put("productId",commentOne.getProductId());
            comment.put("commentPraise",commentOne.getCommentPraise());
            comment.put("commentReturnId",commentOne.getCommentReturnId());
            array.add(comment);
        }
        comments.put("Comments",array);
        return comments.toJSONString();
    }
}
