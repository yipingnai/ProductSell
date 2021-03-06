package com.jj.dao;

import com.jj.domain.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-16 11:16
 */
public interface CustomerDao {
    Customer login(String cname, String cpassword) throws SQLException;

    String register(Customer customer) throws SQLException ;

    Customer queryByCname(String cname) throws SQLException ;

    List<Customer> find() throws SQLException ;

    void delete(String cid) throws SQLException;

    void add(Customer customer) throws SQLException;

    void update(Customer customer) throws SQLException;

    void updateCustomerByCidWithSubsist(String cid, double total) throws SQLException;
}
