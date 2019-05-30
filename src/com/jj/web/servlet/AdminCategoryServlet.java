package com.jj.web.servlet;

import com.jj.domain.Category;
import com.jj.service.CategoryService;
import com.jj.service.impl.CategoryServiceImpl;
import com.jj.util.UUIDUtils;
import com.jj.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author JYM
 * @create 2019-05-16 10:53
 */
@WebServlet(name = "CustomerServlet")
public class AdminCategoryServlet extends BaseServlet {

    public String findAllCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> categories = categoryService.find();
        for (Category category : categories)
            System.out.println(category);
        request.getSession().setAttribute("adminFindCategory",categories);
        return "/admin/category/category_list.jsp";
    }

    public String addCategoryUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/admin/category/add.jsp";
    }
    public String addCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pcname = request.getParameter("pcname");
        System.out.println(pcname);
        Category category = new Category();
        category.setPcid(UUIDUtils.getId());
        category.setPcname(pcname);
        CategoryService categoryService = new CategoryServiceImpl();
        categoryService.add(category);
        System.out.println(pcname);
        response.sendRedirect("/ProductSell/AdminCategoryServlet?method=findAllCategory");
        return null;
    }


    public String updateCategoryUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pcid = request.getParameter("pcid");
        List<Category> categories = (List<Category>)request.getSession().getAttribute("adminFindCategory");
        for(Category category : categories) {
            if(pcid.equals(category.getPcid())){
                request.setAttribute("newCategory",category);
            }
        }
        return "/admin/category/update.jsp";
    }

    public String updateCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pcid = request.getParameter("pcid");
        String pcname = request.getParameter("pcname");
        System.out.println(pcid);
        System.out.println(pcname);
        CategoryService categoryService = new CategoryServiceImpl();
        categoryService.update(pcid, pcname);
        response.sendRedirect("/ProductSell/AdminCategoryServlet?method=findAllCategory");
        return null;
    }
    public String deleteCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pcid = request.getParameter("pcid");
        System.out.println(pcid);
        CategoryService categoryService = new CategoryServiceImpl();
        categoryService.delete(pcid);
        response.sendRedirect("/ProductSell/AdminCategoryServlet?method=findAllCategory");
        return null;
    }

}
