package com.jj.domain;

/**
 * @author JYM
 * @create 2019-05-25 5:51 PM
 */
public class InvoiceItem {
    private  String itemid;//发票项id
    private int quantity;//产品数量
    private double subTotal;//小计
    private Invoice invoice;
    private Product product;//产品

    @Override
    public String toString() {
        return "InvoiceItem{" +
                "itemid='" + itemid + '\'' +
                ", quantity=" + quantity +
                ", subTotal=" + subTotal +
                ", invoice=" + invoice +
                ", product=" + product +
                '}';
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
