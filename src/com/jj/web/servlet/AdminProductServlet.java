package com.jj.web.servlet;

import com.jj.domain.Category;
import com.jj.domain.Product;
import com.jj.service.CategoryService;
import com.jj.service.ProductService;
import com.jj.service.impl.CategoryServiceImpl;
import com.jj.service.impl.ProductServiceImpl;
import com.jj.util.MyBeanUtils;
import com.jj.util.UUIDUtils;
import com.jj.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author JYM
 * @create 2019-05-16 10:53
 */
@WebServlet(name = "CustomerServlet")
public class AdminProductServlet extends BaseServlet {

    public String findAllProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ProductService productService = new ProductServiceImpl();
        List<Product> products = productService.find();
        request.getSession().setAttribute("adminFindProducts",products);
        return "/admin/product/product_list.jsp";
    }
    public String updateProductUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pid = request.getParameter("pid");
        List<Product> products = (List<Product>)request.getSession().getAttribute("adminFindProducts");
        for(Product product : products) {
            if(pid.equals(product.getPid())){
                request.setAttribute("newProduct",product);
            }
        }
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> categories = categoryService.find();
        request.getSession().setAttribute("adminFindCategory",categories);
        return "/admin/product/update.jsp";
    }

    public String updateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String[]> map = request.getParameterMap();
        Product product = new Product();
        MyBeanUtils.populate(product,map);
        ProductService productService = new ProductServiceImpl();
        productService.update(product);
        response.sendRedirect("/ProductSell/AdminProductServlet?method=findAllProduct");
        return null;
    }

    public String addProductUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> categories = categoryService.find();
        request.getSession().setAttribute("adminFindCategory",categories);
        return "/admin/product/add.jsp";
    }
    public String addProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String[]> map = request.getParameterMap();
        Product product = new Product();
        product.setPid(UUIDUtils.getId());
        MyBeanUtils.populate(product,map);
        System.out.println(product);
        ProductService productService = new ProductServiceImpl();
        productService.add(product);
        response.sendRedirect("/ProductSell/AdminProductServlet?method=findAllProduct");
        return null;
    }

    public String deleteCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pid = request.getParameter("pid");
        System.out.println(pid);
        ProductService productService = new ProductServiceImpl();
        productService.delete(pid);
        response.sendRedirect("/ProductSell/AdminProductServlet?method=findAllProduct");
        return null;
    }

}
