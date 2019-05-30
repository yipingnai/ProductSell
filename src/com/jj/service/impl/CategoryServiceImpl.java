package com.jj.service.impl;

import com.jj.dao.CategoryDao;
import com.jj.dao.impl.CategoryDaoImpl;
import com.jj.domain.Category;
import com.jj.domain.Product;
import com.jj.service.CategoryService;
import com.jj.web.servlet.CategoryServlet;

import java.sql.SQLException;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-16 23:21
 */
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> find() throws SQLException {
        CategoryDao categoryDao = new CategoryDaoImpl();
        List<Category> categories = categoryDao.find();
        return categories;

    }

    @Override
    public List<Product> findByPcid(String pcid) throws SQLException {
        CategoryDao categoryDao = new CategoryDaoImpl();
        List<Product> products = categoryDao.find(pcid);
        return products;
    }

    @Override
    public void add(Category category) throws SQLException {
        CategoryDao categoryDao = new CategoryDaoImpl();
        categoryDao.add(category);
    }

    @Override
    public void update(String pcid, String pcname) throws SQLException {
        CategoryDao categoryDao = new CategoryDaoImpl();
        categoryDao.update(pcid, pcname);
    }

    @Override
    public void delete(String pcid) throws SQLException {
        CategoryDao categoryDao = new CategoryDaoImpl();
        categoryDao.delete(pcid);
    }
}
