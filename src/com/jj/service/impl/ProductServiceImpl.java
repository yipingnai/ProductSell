package com.jj.service.impl;

import com.jj.dao.CustomerDao;
import com.jj.dao.ProductDao;
import com.jj.dao.impl.CustomerDaoImpl;
import com.jj.dao.impl.ProductDaoImpl;
import com.jj.domain.Product;
import com.jj.service.ProductService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-16 17:49
 */
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> find() throws SQLException {
        ProductDao productDao = new ProductDaoImpl();
        List<Product> list = productDao.find();
        return list;
    }

    @Override
    public void delete(String pid) throws SQLException {
        ProductDao productDao = new ProductDaoImpl();
        productDao.delete(pid);
    }

    @Override
    public void update(Product product) throws SQLException {
        ProductDao productDao = new ProductDaoImpl();
        productDao.update(product);
    }

    @Override
    public void add(Product product) throws SQLException {
        ProductDao productDao = new ProductDaoImpl();
        productDao.add(product);
    }

    @Override
    public Product findProductByPid(String pid) throws SQLException {
        ProductDao productDao = new ProductDaoImpl();
         Product product =productDao.findProductByPid(pid);
        return product;
    }

    @Override
    public void updateProductByPidWithQuantity(String pid, int amount) throws SQLException {
        ProductDao productDao = new ProductDaoImpl();
        productDao.updateProductByPidWithQuantity(pid,amount);
    }
}
