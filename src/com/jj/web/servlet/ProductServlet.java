package com.jj.web.servlet;

import com.jj.domain.Customer;
import com.jj.domain.Product;
import com.jj.service.CustomerService;
import com.jj.service.impl.CustomerServiceImpl;
import com.jj.util.MyBeanUtils;
import com.jj.util.UUIDUtils;
import com.jj.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author JYM
 * @create 2019-05-16 10:53
 */
@WebServlet(name = "CustomerServlet")
public class ProductServlet extends BaseServlet {

    public String customerInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/jsp/customer_info.jsp";
    }
    public String productInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pid = request.getParameter("pid");
        List<Product> products = (List<Product>)request.getSession().getAttribute("products");
        for (Product product : products) {
            if(product.getPid().equals(pid)){
                //request.getSession().setAttribute("productNewInfo",product);
                request.setAttribute("productNewInfo",product);
            }
        }
        return "/jsp/product_info.jsp";
    }
}
