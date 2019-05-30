package com.jj.domain;

/**
 * @author JYM
 * @create 2019-05-25 4:23 PM
 */
public class CartItem {
    private Product product;//产品信息
    private int quantity;//产品数量
    private double subTotal;//小计

    //计算小计
    public double getSubTotal() {
        return product.getPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
