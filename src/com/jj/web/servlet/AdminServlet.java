package com.jj.web.servlet;

import com.jj.domain.Admin;
import com.jj.domain.Product;
import com.jj.service.AdminService;
import com.jj.service.CategoryService;
import com.jj.service.impl.AdminServiceImpl;
import com.jj.service.impl.CategoryServiceImpl;
import com.jj.util.UUIDUtils;
import com.jj.web.base.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

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
public class AdminServlet extends BaseServlet {


    public String adminLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //接收登录页面
        String anumber = request.getParameter("anumber");
        System.out.println(anumber);
        String apassword = request.getParameter("apassword");
        AdminService adminService = new AdminServiceImpl();
        Admin admin = adminService.findAdmin(anumber, apassword);
        String msg = null;
        System.out.println(admin);
        if(admin == null) {
            msg = "信息错误，重新输入登录！";
            request.setAttribute("msg",msg);
            return "/admin/admin_login.jsp";
        }else {
            request.getSession().setAttribute("newAdmin",admin);
            return "/admin/admin_index.jsp";
        }
    }
    public String exitLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        session.removeAttribute("newAdmin");
        return "/admin/admin_login.jsp";
    }

    public String findAdminByType(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AdminService adminService = new AdminServiceImpl();
        List<Admin> list  = adminService.findAdminByType();
        for(Admin admin :list) {
            System.out.println(admin);
        }
        request.getSession().setAttribute("admins",list);
        return "/admin/admin/admin2_list.jsp";
    }
    //添加管理员
    public String addAdminUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/admin/admin/add.jsp";
    }
    public String addAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String[]> map = request.getParameterMap();
        Admin admin = new Admin();
        admin.setAid(UUIDUtils.getId());
        BeanUtils.populate(admin, map);
        AdminService adminService = new AdminServiceImpl();
        adminService.addAdmin(admin);
        response.sendRedirect("/ProductSell/AdminServlet?method=findAdminByType&type=2");
        return null;
    }
    //修改管理员
    public String updateAdminUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String aid = request.getParameter("aid");
        List<Admin> list = (List<Admin>)request.getSession().getAttribute("admins");
        Admin admin = (Admin)request.getSession().getAttribute("newAdmin");
        String msg = null;
        if(admin.getAid().equals(aid)){
            msg = "当前管理员在线中，请下线后再更改";
            request.setAttribute("msg",msg);
            return "/jsp/info.jsp";
        }
        for(Admin admin1 : list){
            if(admin1.getAid().equals(aid)){
                request.getSession().setAttribute("newAdmin2",admin1);
            }
        }
        return "/admin/admin/update.jsp";
    }

    public String updateAdminByAid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String[]> map = request.getParameterMap();
        Admin admin = new Admin();
        BeanUtils.populate(admin, map);
        AdminService adminService = new AdminServiceImpl();
        adminService.updateAdminByAid(admin);
        response.sendRedirect("/ProductSell/AdminServlet?method=findAdminByType&type=2");
        return null;
    }
    //删除管理员
    public String deleteAdminByAid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String aid = request.getParameter("aid");
        AdminService adminService = new AdminServiceImpl();
        adminService.deleteAdminByAid(aid);
        response.sendRedirect("/ProductSell/AdminServlet?method=findAdminByType&type=2");
        return null;
    }
}
