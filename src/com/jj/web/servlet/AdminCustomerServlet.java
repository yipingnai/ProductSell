package com.jj.web.servlet;

import com.jj.domain.Category;
import com.jj.domain.Customer;
import com.jj.domain.Product;
import com.jj.service.CategoryService;
import com.jj.service.CustomerService;
import com.jj.service.ProductService;
import com.jj.service.impl.CategoryServiceImpl;
import com.jj.service.impl.CustomerServiceImpl;
import com.jj.service.impl.ProductServiceImpl;
import com.jj.util.MyBeanUtils;
import com.jj.util.UUIDUtils;
import com.jj.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author JYM
 * @create 2019-05-16 10:53
 */
@WebServlet(name = "CustomerServlet")
public class AdminCustomerServlet extends BaseServlet {

    public String findAllCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CustomerService customerService = new CustomerServiceImpl();
        List<Customer> customers = customerService.find();
        for (Customer customer : customers)
            System.out.println(customer);
        request.getSession().setAttribute("adminFindCustomer",customers);
        return "/admin/customer/customer_list.jsp";
    }

    public String addCustomerUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/admin/customer/add.jsp";
    }

    public String addCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String[]> map = request.getParameterMap();
        Customer customer = new Customer();
        customer.setCid(UUIDUtils.getId());
        MyBeanUtils.populate(customer, map);
        System.out.println(customer);
        CustomerService customerService = new CustomerServiceImpl();
        customerService.add(customer);
        response.sendRedirect("/ProductSell/AdminCustomerServlet?method=findAllCustomer");
        return null;
    }

    public String deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String cid = request.getParameter("cid");
        System.out.println(cid);
        CustomerService customerService = new CustomerServiceImpl();
        customerService.delete(cid);
        response.sendRedirect("/ProductSell/AdminCustomerServlet?method=findAllCustomer");
        return null;
    }

    public String updateCustomerUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String cid = request.getParameter("cid");
        List<Customer> customers = (List<Customer>)request.getSession().getAttribute("adminFindCustomer");
        for(Customer category : customers) {
            if(cid.equals(category.getCid())){
                request.setAttribute("newCustomer",category);
            }
        }
        return "/admin/customer/update.jsp";
    }

    public String updateCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String[]> map = request.getParameterMap();
        Customer customer = new Customer();
        MyBeanUtils.populate(customer,map);
        CustomerService customerService = new CustomerServiceImpl();
        customerService.update(customer);
        response.sendRedirect("/ProductSell/AdminCustomerServlet?method=findAllCustomer");
        return null;
    }



}
