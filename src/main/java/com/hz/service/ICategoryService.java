package com.hz.service;

import com.hz.pojo.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
public interface ICategoryService{
    List<Category> getCategory();
    boolean insertCategory(@Param("category")Category category);
}
