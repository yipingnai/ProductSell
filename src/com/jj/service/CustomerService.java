package com.jj.service;

import com.jj.domain.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-16 11:11
 */
public interface CustomerService {
    public Customer login(String cname, String cpassword) throws SQLException;

    public String register(Customer customer) throws SQLException;

    List<Customer> find() throws SQLException;

    void delete(String cid) throws SQLException;

    void add(Customer customer) throws SQLException;

    void update(Customer customer) throws SQLException;

    void updateCustomerByCidWithSubsist(String cid, double total)throws SQLException;
}
