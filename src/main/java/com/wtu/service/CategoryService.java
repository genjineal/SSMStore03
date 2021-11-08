package com.wtu.service;

import com.wtu.entity.Category;

import java.util.List;

/**
 * @author chuang
 * @version 1.0
 * @date 2021/11/2 19:23
 */
public interface CategoryService {
    //查询所有商品类型
    List<Category> allCategoryList();
}
