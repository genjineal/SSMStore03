package com.wtu.util;

import java.io.File;

/**
 * @author chuang
 * @version 1.0
 * @date 2021/11/1 14:06
 */
//工具 分页 条件查询
public class Params {
    private int pageNum;//当前页
    private int pageSize = 10;//每页条数

    //商品条件查询的参数 根据商品名模糊搜素
    private String detial;
    private String typeId;
    private String uname;
    private String uphone;
    private Integer uid;

    public Params() {
    }

    public Params(int pageNum, int pageSize, String detial, String typeId) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.detial = detial;
        this.typeId = typeId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getDetial() {
        return detial;
    }

    public void setDetial(String detial) {
        this.detial = detial;
    }


    //工具类中定义 删除图片的方法
    //定义删除文件操作
    public boolean deleteProImg(String url){
        String path = "D:\\ideaSSM\\SSMStore\\src\\main\\webapp";
        if(url!=null){
            File oldFile = new File(path,url);
            oldFile.delete();//删除
            return true;
        }else {
            return false;
        }
    }
}
