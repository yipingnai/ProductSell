package com.jj.web.servlet;

import com.jj.domain.*;
import com.jj.service.ProductService;
import com.jj.service.impl.ProductServiceImpl;
import com.jj.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author JYM
 * @create 2019-05-16 10:53
 */
@WebServlet(name = "CustomerServlet")
public class CartServlet extends BaseServlet {

    //添加到购物车
    public String addCartItemToCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pid = request.getParameter("pid");//产品id
        int quantity = Integer.parseInt(request.getParameter("quantity"));//产品数量
        //获取cart对象session中
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        //如何没有cart对象，创建并放到
        if(cart == null){
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        //调用方法查找产品信息
        ProductService productService = new ProductServiceImpl();
        Product product = productService.findProductByPid(pid);
        //创建购物项赋值
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(quantity);
        cartItem.setProduct(product);

        //调用购物车的方法吧购物项添加到购物车里
        cart.addCartItemToCart(cartItem);

        //重定向到/jsp/cart.jsp
        response.sendRedirect("/ProductSell/jsp/cart.jsp");
        return null;
    }


    public String findCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.sendRedirect("/ProductSell/jsp/cart.jsp");
        return null;
    }

    public String removeCartItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pid = request.getParameter("pid");//获取要移除购物项产品的id
        Cart cart = (Cart)request.getSession().getAttribute("cart");//获取购物车对象
        //调用cart的移除购物项方法
        cart.remove(pid);
        response.sendRedirect("/ProductSell/jsp/cart.jsp");
        return null;
    }

    //移除购物车
    public String removeCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cart cart = (Cart)request.getSession().getAttribute("cart");//获取购物车对象
        //调用cart的移除购物车方法
        cart.clearCart();
        response.sendRedirect("/ProductSell/jsp/cart.jsp");
        return null;
    }
}
