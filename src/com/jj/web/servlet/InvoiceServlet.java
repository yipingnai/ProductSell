package com.jj.web.servlet;

import com.jj.domain.*;
import com.jj.service.CustomerService;
import com.jj.service.InvoiceService;
import com.jj.service.ProductService;
import com.jj.service.impl.CustomerServiceImpl;
import com.jj.service.impl.InvoiceServiceImpl;
import com.jj.service.impl.ProductServiceImpl;
import com.jj.util.UUIDUtils;
import com.jj.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-16 10:53
 */
@WebServlet(name = "CustomerServlet")
public class InvoiceServlet extends BaseServlet {


    public String saveCartToInvoice(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Customer customer = (Customer) request.getSession().getAttribute("loginCustomer");
        if(customer == null){
            request.setAttribute("msg", "请登录之后在下单");
            return "/jsp/login.jsp";
        }


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String format = df.format(new Date());
        System.out.println(format);
        Date date = df.parse(format);


        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Invoice invoice = new Invoice();
        invoice.setIid(UUIDUtils.getId());
        invoice.setCustomer(customer);
        invoice.setTotal(cart.getTotal());
        invoice.setDate(date);
        for(CartItem cartItem : cart.getList()){
            InvoiceItem invoiceItem = new InvoiceItem();
            invoiceItem.setProduct(cartItem.getProduct());
            invoiceItem.setQuantity(cartItem.getQuantity());
            invoiceItem.setSubTotal(cartItem.getSubTotal());
            invoiceItem.setInvoice(invoice);
            invoiceItem.setItemid(UUIDUtils.getId());
            invoice.getList().add(invoiceItem);
        }
        //判断客户预付款是否足够下单
        double subsist = Double.parseDouble(request.getParameter("subsist"));
        if(subsist < cart.getTotal()){
            request.setAttribute("msg", "预付款不足以下单，请先充值！");
            return "/jsp/login.jsp";
        }
        //将发票保存到数据库
        InvoiceService invoiceService = new InvoiceServiceImpl();
        invoiceService.addInvoice(invoice);
        //清空购物车
        cart.clearCart();
        //将购买后的产品数量和客户预付款改变
        //通过产品id 和购买数量更新产品表
        ProductService productService = new ProductServiceImpl();
        for(InvoiceItem invoiceItem : invoice.getList()){
            productService.updateProductByPidWithQuantity(invoiceItem.getProduct().getPid(),invoiceItem.getProduct().getAmount()-invoiceItem.getQuantity());
        }
        //通过发票总计更新客户表
        //通过客户id和发票总计更新客户表
        CustomerService customerService = new CustomerServiceImpl();
        customerService.updateCustomerByCidWithSubsist(invoice.getCustomer().getCid(),subsist - invoice.getTotal());
        //将发票放到request
        request.getSession().setAttribute("invoice",invoice);
        response.sendRedirect("/ProductSell/jsp/invoice.jsp");
        return null;
    }
    public String findAllInvoiceByCid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Customer customer = (Customer) request.getSession().getAttribute("loginCustomer");//获取当前客户
        InvoiceService invoiceService = new InvoiceServiceImpl();
        List<Invoice> list =  invoiceService.findAllInvoiceByCid(customer.getCid());
        for(Invoice invoice : list){
            System.out.println(invoice);
        }
        request.getSession().setAttribute("invoices",list);
        response.sendRedirect("/ProductSell/jsp/invoice_list.jsp");
        return null;
    }
}

