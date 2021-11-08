package com.wtu.controller;

import com.wtu.entity.Category;
import com.wtu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author chuang
 * @version 1.0
 * @date 2021/11/6 9:59
 */
@Controller
public class FileUploadController {
    @Autowired
    private CategoryService categoryService;

    //文件上传：返回上传的结果
    //D:\ideaSSM\SSMStore\src\main\webapp\jsp\statics\images\add
    //文件上传思路: 用户选择自己电脑上的文件,提交请求,服务器/程序指定图片上传储存的位置
    //服务器指定位置: 路径(目录)+图片名称
    //1 准备上传文件(位置)
    @RequestMapping(value = "/upload",produces = "application/json;charset=utf-8")
    public String Upload(MultipartFile file, Model model){
        String originalFilename = file.getOriginalFilename();//名称包括:文件名和后缀(文件类型)
        //转换为唯一：先获取文件类型(.和后面的字符) 然后通过UUID产生随机字符作为文件名称(不带后缀)
        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
        //产生文件名(不带后缀) 图片完整名称为 fileName+fileType
        //文件名
        String fileName = UUID.randomUUID().toString();
        //上传根目录
        String outPath = "D:\\ideaSSM\\SSMStore\\src\\main\\webapp\\jsp\\statics\\images\\add";
        String urlPath = "\\jsp\\statics\\images\\add";
        File fileUpload = new File(outPath);
        if (!fileUpload.exists()) {
            fileUpload.mkdirs();
        }
        //上传文件的完整路径 ： 根目录+子目录+文件名(没有后缀)+文件类型
        String finalPath = outPath + "/" + fileName + fileType;
        System.out.println("finalPath = " + finalPath);
        //上传到mysql库中的路径 回传到页面
        String url = urlPath + "/" + fileName + fileType;
        //2上传
        try {
            file.transferTo(new File(finalPath));//执行上传
            //将分类传递到页面
            List<Category> categoryList = categoryService.allCategoryList();
            model.addAttribute("categoryList",categoryList);
            //将url传回页面
            model.addAttribute("url",url);
            //成功后返回页面
            return "adminAddPro";
        } catch (IOException e) {
            e.printStackTrace();
            return "adminAddPro";
        }
    }




}
