package com.jj.web.servlet;

import com.jj.domain.Customer;
import com.jj.service.CustomerService;
import com.jj.service.impl.CustomerServiceImpl;
import com.jj.util.MyBeanUtils;
import com.jj.util.UUIDUtils;
import com.jj.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author JYM
 * @create 2019-05-16 10:53
 */
@WebServlet(name = "CustomerServlet")
public class CustomerServlet extends BaseServlet {

    public String loginUI(HttpServletRequest request, HttpServletResponse response) {
        return "/jsp/login.jsp";
    }
    public String registerUI(HttpServletRequest request, HttpServletResponse response) {
        return "/jsp/register.jsp";
    }
    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String cname = request.getParameter("cname");
        String cpassword = request.getParameter("cpassword");
        System.out.println(cname + "---" + cpassword);
        CustomerService customerSerice = new CustomerServiceImpl();
        Customer customer = customerSerice.login(cname, cpassword);

        if(customer != null){
            System.out.println(customer);
            request.getSession().setAttribute("loginCustomer",customer);
            response.sendRedirect("/ProductSell/jsp/index.jsp");
            return null;
        }else{
            System.out.println("ss");
            String msg = "用户名或密码有误";
            System.out.println(msg);
            request.setAttribute("msg",msg);
            return "/jsp/login.jsp";
        }
    }
    public String register(HttpServletRequest request, HttpServletResponse response) throws Exception {
        /*String cname = request.getParameter("cname");
        String cpassword = request.getParameter("cpassword");*/
        Map<String, String[]> parameterMap = request.getParameterMap();
        Customer customer = new Customer();
        MyBeanUtils.populate(customer,parameterMap);
        customer.setCid(UUIDUtils.getId());
        CustomerService customerSerice = new CustomerServiceImpl();
        String register = customerSerice.register(customer);
        String msg = null;
        if("success".equals(register)){
            msg = "注册成功，请登录";
            request.setAttribute("msg",msg);
            return "/jsp/login.jsp";
        }else {
            msg = "注册失败，请重新注册";
            request.setAttribute("msg",msg);
            return "/jsp/register.jsp";
        }
    }

    public String exitLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        session.removeAttribute("loginCustomer");
        //session.invalidate();
        return "/jsp/index.jsp";
    }

    public String customerInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/jsp/customer_info.jsp";
    }
}
