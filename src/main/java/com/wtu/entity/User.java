package com.wtu.entity;

/**
 * @author chuang
 * @version 1.0
 * @date 2021/11/1 14:05
 */
public class User {
    private Integer uid;    //编号
    private String uname;   //用户名
    private String password;    //密码
    private String uphone;  //电话
    private String address; //地址
    private String sex; //性别
    private Integer age;//年龄
    private Integer status;//用户状态

    public User() {
    }

    public User(String uname, String password, String uphone, String address, String sex, Integer age, Integer status) {
        this.uname = uname;
        this.password = password;
        this.uphone = uphone;
        this.address = address;
        this.sex = sex;
        this.age = age;
        this.status = status;
    }

    public User(Integer uid, String uname, String password, String uphone, String address, String sex, Integer age, Integer status) {
        this.uid = uid;
        this.uname = uname;
        this.password = password;
        this.uphone = uphone;
        this.address = address;
        this.sex = sex;
        this.age = age;
        this.status = status;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", uphone='" + uphone + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", status=" + status +
                '}';
    }
}
