package com.wtu.service;

import com.wtu.entity.Category;
import com.wtu.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chuang
 * @version 1.0
 * @date 2021/11/2 19:23
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryMapper categoryMapper;
    //查询所有商品类型

    public List<Category> allCategoryList() {
        return categoryMapper.allCategoryList();
    }
}
