package com.wtu.entity;

public class Product {
    private Integer pid;

    private String pname;

    private String detial;

    private String url;

    private Double price;

    private Integer stock;

    private Integer typeid;

    private Integer status;

    //生成的类型名字
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getDetial() {
        return detial;
    }

    public void setDetial(String detial) {
        this.detial = detial == null ? null : detial.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Product() {
    }

    public Product(String pname, String detial, String url, Double price, Integer stock, Integer typeid) {
        this.pname = pname;
        this.detial = detial;
        this.url = url;
        this.price = price;
        this.stock = stock;
        this.typeid = typeid;
    }

    public Product(Integer pid, String pname, String detial, String url, Double price, Integer stock, Integer typeid, Integer status) {
        this.pid = pid;
        this.pname = pname;
        this.detial = detial;
        this.url = url;
        this.price = price;
        this.stock = stock;
        this.typeid = typeid;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", detial='" + detial + '\'' +
                ", url='" + url + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", typeid=" + typeid +
                ", status=" + status +
                '}';
    }
}