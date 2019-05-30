package com.jj.dao.impl;

import com.jj.dao.CustomerDao;
import com.jj.domain.Customer;
import com.jj.util.JDBCUtils;
import com.jj.util.UUIDUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-16 11:15
 */
public class CustomerDaoImpl implements CustomerDao {
    @Override
    public Customer login(String cname, String cpassword) throws SQLException {
        String sql = "select * from customer where cname = ? and cpassword = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Customer customer = queryRunner.query(sql, new BeanHandler<Customer>(Customer.class), cname, cpassword);
        return customer;
    }

    @Override
    public String register(Customer customer) throws SQLException {
        String sql ="insert into customer set cid = ?,cname = ?,cpassword = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        int update = queryRunner.update(sql, customer.getCid(), customer.getCname(),customer.getCpassword());
        return update > 0 ? "success" : "failure";
    }

    @Override
    public Customer queryByCname(String cname) throws SQLException  {
        String sql = "select * from customer where cname =?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Customer customer = queryRunner.query(sql, new BeanHandler<Customer>(Customer.class), cname);
        return customer;
    }

    @Override
    public List<Customer> find() throws SQLException {
        String sql = "select * from customer";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Customer> customers = queryRunner.query(sql, new BeanListHandler<Customer>(Customer.class));
        return customers;
    }

    @Override
    public void delete(String cid) throws SQLException {
        String sql = "delete from customer where cid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update(sql,cid);
    }

    @Override
    public void add(Customer customer) throws SQLException {
        String sql = "insert into customer values(?,?,?,?,?,?,?,?)";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update(sql,customer.getCid(), customer.getCname(), customer.getCpassword(), customer.getAddress(), customer.getTelephone(), customer.getCredit(), customer.getSubsist(), customer.getType());
    }

    @Override
    public void update(Customer customer) throws SQLException {
        String sql = "update customer set cname = ?,cpassword = ?, address = ?, telephone = ?, credit = ?, subsist = ?, type = ? where cid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update(sql, customer.getCname(), customer.getCpassword(), customer.getAddress(), customer.getTelephone(), customer.getCredit(), customer.getSubsist(), customer.getType(), customer.getCid());
    }

    @Override
    public void updateCustomerByCidWithSubsist(String cid, double total) throws SQLException {
        String sql = "update customer set subsist = ? where cid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update(sql,total, cid);
    }
}
