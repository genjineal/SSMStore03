package com.wtu.service;

import com.github.pagehelper.PageHelper;
import com.wtu.entity.Product;
import com.wtu.mapper.ProductMapper;
import com.wtu.util.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author chuang
 * @version 1.0
 * @date 2021/11/2 13:54
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductMapper productMapper;
    //查询所有商品

    public List<Product> productLists() {
        return productMapper.productLists();
    }
    //带条件以及分页查询所有商品

    public List<Product> productLists(Params params) {
        //默认初始第一页  动态给，用户第一次进入才给1
        if(params.getPageNum() ==0){
            params.setPageNum(1);
        }
        //需要当前页、每页条数
        PageHelper.startPage(params.getPageNum(),params.getPageSize());
        return productMapper.productLists(params);
    }
    //根据id查询商品传递数据到商品详情页

    public Product selectProById(Integer pid) {
        return productMapper.selectProById(pid);
    }
    //对应用户下订单后 商品减去相应的库存

    public int changeProAmount(Map<String,Object> map) {
        return productMapper.changeProAmount(map);
    }

    //管理员查询所有商品

    public List<Product> selectAllProduct(Params params) {
        //默认初始第一页  动态给，用户第一次进入才给1
        if(params.getPageNum() ==0){
            params.setPageNum(1);
        }
        params.setPageSize(8);
        //需要当前页、每页条数
        PageHelper.startPage(params.getPageNum(),params.getPageSize());
        return productMapper.selectAllProduct(params);
    }

    //管理员执行修改商品

    public int updateProById(Map map) {
        return productMapper.updateProById(map);
    }

    //管理员添加商品

    public int insertPro(Map map) {
        return productMapper.insertPro(map);
    }

    //管理员删除商品，连带本地图片的删除

    public int deleteProById(Integer pid) {
        return productMapper.deleteProById(pid);
    }

}
