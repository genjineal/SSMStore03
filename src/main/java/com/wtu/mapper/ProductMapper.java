package com.wtu.mapper;

import com.wtu.entity.Product;
import com.wtu.entity.ProductExample;
import com.wtu.util.Params;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductMapper {
    //查询所有商品
    List<Product> productLists();
    //带条件以及分页查询所有商品
    List<Product> productLists(Params params);
    //根据商品id查询单个商品
    Product selectProById(Integer pid);

    //对应用户下单 减去响应的库存
    int changeProAmount(Map<String,Object> map);

    //管理员查询所有商品
    List<Product> selectAllProduct(Params params);

    //管理员执行修改商品
    int updateProById(Map map);

    //管理员添加商品
    int insertPro(Map map);

    //管理员删除商品，连带本地图片的删除
    int deleteProById(Integer pid);

    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}