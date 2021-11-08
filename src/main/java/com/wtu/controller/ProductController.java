package com.wtu.controller;

import com.github.pagehelper.PageInfo;
import com.wtu.entity.Category;
import com.wtu.entity.Product;
import com.wtu.entity.User;
import com.wtu.service.CategoryService;
import com.wtu.service.ProductService;
import com.wtu.util.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chuang
 * @version 1.0
 * @date 2021/11/2 13:56
 */
@Controller
@RequestMapping("/pro")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;//在页面初始化的时候传递 商品类型展示
    //显示所有商品的
    @RequestMapping("/list")
    public String getAllProducts(Model model, Params params, HttpSession session){
        //判断是否非用户进入
        if(session.getAttribute("user")==null){
            return "userLogin";
        }
        //把获取的用户信息放到页面上
        User user = (User) session.getAttribute("user");
        session.setAttribute("user",user);
        //将商品类型传递到页面
        List<Category> categoryList = categoryService.allCategoryList();
        model.addAttribute("categoryList",categoryList);
        List<Product> productList = productService.productLists(params);
        //将获取的数据，交给分页实现类处理
        PageInfo<Product> pageInfo = new PageInfo<Product>(productList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("params",params);
        return "productList";
    }
    //退出登录功能
    @RequestMapping("/backlogin")
    public String backLogin(HttpSession session){
        session.removeAttribute("user");
        return "userLogin";
    }

    //进入商品详情页 ① 根据id 查到商品
    @RequestMapping("/choicePro")
    public String choiceProduct(Integer pid,Model model,HttpSession session){
        Product product = productService.selectProById(pid);
        model.addAttribute("product",product);
        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "productDetial";
    }

    //管理员查询所有商品
    @RequestMapping("/selectAllProduct")
    public String selectAllProduct(Params params,Model model){
        //调用方法 获取商品的集合
        List<Product> productList = productService.selectAllProduct(params);
        //把集合交给分页处理
        PageInfo<Product> pageInfo = new PageInfo<Product>(productList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("params",params);
        return "adminConProduct";
    }

    //管理员修改商品 ①查询到单个商品
    @RequestMapping("/adminSelectPro")
    public String adminSelectPro(Integer pid,Model model){
        Product product = productService.selectProById(pid);
        model.addAttribute("product",product);
        return "adminUpdatePro";
    }

    //执行商品的修改
    @RequestMapping("/updatePro")
    public String updatePro(Product pro){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("detial",pro.getDetial());
        map.put("price",pro.getPrice());
        map.put("stock",pro.getStock());
        map.put("status",pro.getStatus());
        map.put("pid",pro.getPid());
        productService.updateProById(map);
        return "redirect:/pro/selectAllProduct";
    }
    //添加商品页面 将商品类型传递
    @RequestMapping("/sendCategory")
    public String sendCategory(Model model){
        //将商品类型传递到页面
        List<Category> categoryList = categoryService.allCategoryList();
        model.addAttribute("categoryList",categoryList);
        return "adminAddPro";
    }
    //管理员添加商品，返回所有商品页面
    @RequestMapping("/insertPro")
    public String insertPro(Product pro){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("pname",pro.getPname());
        map.put("detial",pro.getDetial());
        map.put("url",pro.getUrl());
        map.put("price",pro.getPrice());
        map.put("stock",pro.getStock());
        map.put("typeid",pro.getTypeid());
        map.put("status",pro.getStatus());
        productService.insertPro(map);
        return "redirect:/pro/selectAllProduct";
    }
    //管理员删除商品，会连带删除本地的图片信息
    @RequestMapping("/deleteProById")
    public String deleteProById(Integer pid,String url,Params params){
        productService.deleteProById(pid);
        boolean b = params.deleteProImg(url);
        if (b){
            System.out.println("删除成功");
            return "redirect:/pro/selectAllProduct";
        }else {
            System.out.println("删除失败");
            return "redirect:/pro/selectAllProduct";
        }
    }
}
