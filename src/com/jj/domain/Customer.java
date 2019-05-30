package com.jj.domain;

/**
 * @author JYM
 * @create 2019-04-28 21:47
 */
public class Customer {
    private String cid;
    private String cname;//客户名称
    private String cpassword;//客户密码
    private String address;//客户地址
    private String telephone;//客户电话
    private int credit;//信用状况1优2良3一般4差
    private double subsist;//预付款
    private int type;//类型 1管理员2会员3普通用户

    public Customer(String cid, String cname, String cpassword, String address, String telephone, int credit, double subsist, int type) {
        this.cid = cid;
        this.cname = cname;
        this.cpassword = cpassword;
        this.address = address;
        this.telephone = telephone;
        this.credit = credit;
        this.subsist = subsist;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Customer() {
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public double getSubsist() {
        return subsist;
    }

    public void setSubsist(double subsist) {
        this.subsist = subsist;
    }

}
