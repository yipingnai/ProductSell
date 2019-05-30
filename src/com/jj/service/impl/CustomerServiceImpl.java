package com.jj.service.impl;

import com.jj.dao.CustomerDao;
import com.jj.dao.impl.CustomerDaoImpl;
import com.jj.domain.Customer;
import com.jj.service.CustomerService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-16 11:12
 */
public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer login(String cname, String cpassword) throws SQLException {
        CustomerDao customerDao = new CustomerDaoImpl();
        Customer customer = customerDao.login(cname, cpassword);
        return customer;
    }

    @Override
    public String register(Customer customer) throws SQLException {
        CustomerDao customerDao = new CustomerDaoImpl();
        //查询用户名是否存在
        Customer cust = customerDao.queryByCname(customer.getCname());
        if(cust == null){
            String register = customerDao.register(customer);
            if("success".equals(register))
                return "success";
        }
        return "failure";
    }

    @Override
    public List<Customer> find() throws SQLException {
        CustomerDao customerDao = new CustomerDaoImpl();
        List<Customer> customers = customerDao.find();
        return customers;
    }

    @Override
    public void delete(String cid) throws SQLException {
        CustomerDao customerDao = new CustomerDaoImpl();
        customerDao.delete(cid);
    }

    @Override
    public void add(Customer customer) throws SQLException {
        CustomerDao customerDao = new CustomerDaoImpl();
        customerDao.add(customer);
    }

    @Override
    public void update(Customer customer) throws SQLException {
        CustomerDao customerDao = new CustomerDaoImpl();
        customerDao.update(customer);
    }

    @Override
    public void updateCustomerByCidWithSubsist(String cid, double total) throws SQLException {
        CustomerDao customerDao = new CustomerDaoImpl();
        customerDao.updateCustomerByCidWithSubsist(cid, total);
    }


}
