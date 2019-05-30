package com.jj.web.servlet;

import com.jj.domain.Category;
import com.jj.domain.Product;
import com.jj.service.CategoryService;
import com.jj.service.ProductService;
import com.jj.service.impl.CategoryServiceImpl;
import com.jj.service.impl.ProductServiceImpl;
import com.jj.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-16 17:20
 */
@WebServlet(name = "IndextServlet")
public class IndextServlet extends BaseServlet {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        ProductService productService = new ProductServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();
        try {
            List<Product> products = productService.find();
            List<Category> categories = categoryService.find();
            request.getSession().setAttribute("products",products);
            request.getSession().setAttribute("categories",categories);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "/jsp/index.jsp";
    }
}
