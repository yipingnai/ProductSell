package com.jj.dao;

import com.jj.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-16 17:49
 */
public interface ProductDao {

    public List<Product> find() throws SQLException;

    void delete(String pid) throws SQLException;

    void update(Product product) throws SQLException;

    void add(Product product) throws SQLException;

    Product findProductByPid(String pid)  throws SQLException;

    void updateProductByPidWithQuantity(String pid, int amount) throws SQLException;
}
