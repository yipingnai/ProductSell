package com.jj.web.servlet;

import com.jj.domain.Category;
import com.jj.domain.Customer;
import com.jj.domain.Product;
import com.jj.service.CategoryService;
import com.jj.service.CustomerService;
import com.jj.service.impl.CategoryServiceImpl;
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
public class CategoryServlet extends BaseServlet {


    public String findCategoryByPcid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pcid = request.getParameter("pcid");
        CategoryService categoryService = new CategoryServiceImpl();
        List<Product> products = categoryService.findByPcid(pcid);
        request.getSession().setAttribute("products",products);
        return "/jsp/index.jsp";
    }
}
