package com.jj.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-25 4:25 PM
 */
public class Cart {
    private double total;//购物车总计
    private List<CartItem> list = new ArrayList<>();

    //添加购物项到购物车
    public void addCartItemToCart(CartItem cartItem){
        //先判断购物车是否有该购物项
        boolean flag = false;//默认不存在
        CartItem oldCartItem = null;//原先的购物项
        for(CartItem cartItem1 : list){
            if(cartItem1.getProduct().getPid().equals(cartItem.getProduct().getPid())){
                flag = true;
                oldCartItem = cartItem1;
            }
        }
        if(flag == false){//购物车不存在该购物项，直接添加
            list.add(cartItem);
        }else {
            // 获取到原先的数量,获取到本次的数量,相加之后设置到原先购物项上
            oldCartItem.setQuantity(oldCartItem.getQuantity() + cartItem.getQuantity());
        }
    }

  /*  //返回list中所有的值
    public List<CartItem> getCartItem(){
        for(CartItem cartItem : list){

        }
        return null;
    }*/
    //移除购物项
    //用户点击移除购物项链接,可以将当前的购物类别的商品id发送到服务端
    public void remove(String pid){
        /*for(CartItem cartItem : list) {
            if(cartItem.getProduct().getPid().equals(pid)){
                list.remove(cartItem);
            }
        }*/
        Iterator<CartItem> it = list.iterator();
        while (it.hasNext()){
            CartItem cartItem = it.next();
            if(cartItem.getProduct().getPid().equals(pid)){
                it.remove();
            }
        }
    }

    //清空购物车
    public void clearCart(){
        list.clear();
    }

    //获取总计
    public double getTotal() {
        total = 0;
        for(CartItem cartItem : list){
            total += cartItem.getSubTotal();
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<CartItem> getList() {
        return list;
    }

    public void setList(List<CartItem> list) {
        this.list = list;
    }
}
