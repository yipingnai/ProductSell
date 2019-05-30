package com.jj.dao;

import com.jj.domain.Category;
import com.jj.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-16 23:22
 */
public interface CategoryDao {
    public List<Category> find() throws SQLException;

    List<Product> find(String pcid) throws SQLException;

    void add(Category category) throws SQLException;

    void update(String pcid, String pcname) throws SQLException;

    void delete(String pcid) throws SQLException;
}
