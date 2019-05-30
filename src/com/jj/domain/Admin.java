package com.jj.domain;

/**
 * @author JYM
 * @create 2019-05-27 12:40 PM
 */
public class Admin {
    private String aid;
    private String aname;
    private String anumber;
    private String apassword;
    private int type;//1超级管理员2普通管理员

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getAnumber() {
        return anumber;
    }

    public void setAnumber(String anumber) {
        this.anumber = anumber;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aid='" + aid + '\'' +
                ", aname='" + aname + '\'' +
                ", anumber='" + anumber + '\'' +
                ", apassword='" + apassword + '\'' +
                ", type=" + type +
                '}';
    }
}
