package com.jj.domain;

/**
 * @author JYM
 * @create 2019-05-15 22:43
 * 分类实体
 */
public class Category {
    private String pcid;//产品分类编号
    private String pcname;//产品分类名称

    public Category(String pcid, String pcname) {
        this.pcid = pcid;
        this.pcname = pcname;
    }

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "pcid='" + pcid + '\'' +
                ", pcname='" + pcname + '\'' +
                '}';
    }

    public String getPcid() {
        return pcid;
    }

    public void setPcid(String pcid) {
        this.pcid = pcid;
    }

    public String getPcname() {
        return pcname;
    }

    public void setPcname(String pcname) {
        this.pcname = pcname;
    }
}
