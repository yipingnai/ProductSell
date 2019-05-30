package com.jj.service;

import com.jj.domain.Category;
import com.jj.domain.Product;
import com.jj.web.servlet.CategoryServlet;

import java.sql.SQLException;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-16 23:19
 */
public interface CategoryService {
    public List<Category> find() throws SQLException;

    List<Product> findByPcid(String pcid) throws SQLException;

    void add(Category category) throws SQLException;

    void update(String pcid, String pcname) throws SQLException;

    void delete(String pcid) throws SQLException;
}
