package com.wtu.entity;

public class Record {
    private Integer rid;

    private Integer uid;

    private Integer pid;

    private Integer amount;

    private String pname;

    private String uname;

    private String uphone;

    private String address;

    private Integer status;

    public Record() {
    }

    public Record(Integer uid, Integer pid, Integer amount, String pname, String uname, String uphone, String address) {
        this.uid = uid;
        this.pid = pid;
        this.amount = amount;
        this.pname = pname;
        this.uname = uname;
        this.uphone = uphone;
        this.address = address;
    }

    public Record(Integer rid, Integer uid, Integer pid, Integer amount, String pname, String uname, String uphone, String address, Integer status) {
        this.rid = rid;
        this.uid = uid;
        this.pid = pid;
        this.amount = amount;
        this.pname = pname;
        this.uname = uname;
        this.uphone = uphone;
        this.address = address;
        this.status = status;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Record{" +
                "rid=" + rid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", amount=" + amount +
                ", pname='" + pname + '\'' +
                ", uname='" + uname + '\'' +
                ", uphone='" + uphone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }
}