package com.hz.service.impl;

import com.hz.pojo.Category;
import com.hz.mapper.CategoryMapper;
import com.hz.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class CategoryServiceImpl implements  ICategoryService{

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategory() {
        return categoryMapper.getCategory();
    }

    @Override
    public boolean insertCategory(Category category) {
        return categoryMapper.insertCategory(category)>0;
    }
}
