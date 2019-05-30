package com.jj.dao.impl;

import com.jj.dao.ProductDao;
import com.jj.domain.Product;
import com.jj.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-16 17:50
 */
public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> find() throws SQLException {
        String sql = "select * from product";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class));
        return list;
    }

    @Override
    public void delete(String pid) throws SQLException {
        String sql = "delete from product where pid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update(sql,pid);
    }

    @Override
    public void update(Product product) throws SQLException {
        String sql = "update product set pname = ?,format = ?,info = ?,amount = ?,price = ?,pcid = ? where pid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update(sql,product.getPname(), product.getFormat(), product.getInfo(), product.getAmount(), product.getPrice(), product.getPcid(), product.getPid());
    }

    @Override
    public void add(Product product) throws SQLException {
        String sql = "insert into product values (?,?,?,?,?,?,?)";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update(sql,product.getPid(),product.getPname(), product.getFormat(), product.getPrice(), product.getAmount(), product.getPcid(), product.getInfo());
    }

    @Override
    public Product findProductByPid(String pid) throws SQLException {
        String sql = "select * from product where pid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Product product = queryRunner.query(sql, new BeanHandler<Product>(Product.class), pid);
        return product;
    }

    @Override
    public void updateProductByPidWithQuantity(String pid, int amount) throws SQLException {
        String sql = "update product set amount = ? where pid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update(sql,amount, pid);
    }
}
