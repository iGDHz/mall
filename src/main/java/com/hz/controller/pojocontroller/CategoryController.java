package com.hz.controller.pojocontroller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hz.controller.BaseController;
import com.hz.pojo.Category;
import com.hz.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
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
@RequestMapping("/category")
public class CategoryController extends BaseController {

    @Autowired
    CategoryServiceImpl categoryService;

    @RequestMapping(value = "/getcategory",method = RequestMethod.GET)
    public String getCategory(){
        JSONObject res = new JSONObject();
        List<Category> list = categoryService.getCategory();
        JSONArray array = new JSONArray();
        for(Category category : list){
            JSONObject json = new JSONObject();
            json.put("Category",category.getCategoryName());
            array.add(json);
        }
        logger.info("获取分类信息");
        res.put("CategoryList",array);
        return res.toJSONString();
    }
}
