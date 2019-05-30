package com.jj.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-25 5:51 PM
 */
public class Invoice {
    private String iid;//发票id
    private double total;//总计
    private Date date;//发票日期
    private Customer customer;//发票客户
    private List<InvoiceItem> list = new ArrayList<>();//发票项集合

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<InvoiceItem> getList() {
        return list;
    }

    public void setList(List<InvoiceItem> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "iid='" + iid + '\'' +
                ", total=" + total +
                ", date=" + date +
                ", customer=" + customer +
                ", list=" + list +
                '}';
    }
}
