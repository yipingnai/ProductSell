package com.jj.domain;

/**
 * @author JYM
 * @create 2019-04-14 20:34
 * 产品实体
 */
public class Product {
    private String pid; //产品id
    private String pname;//产品名称
    private String format;//产品规格
    private String info;//产品信息
    private double price;//产品价格
    private int amount;//产品数量
    private String pcid;//商品所属分类id

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", format='" + format + '\'' +
                ", info='" + info + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", pcid='" + pcid + '\'' +
                '}';
    }

    public String getPcid() {
        return pcid;
    }

    public void setPcid(String pcid) {
        this.pcid = pcid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
