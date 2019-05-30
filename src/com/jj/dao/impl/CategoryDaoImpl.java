package com.jj.dao.impl;

import com.jj.dao.CategoryDao;
import com.jj.domain.Category;
import com.jj.domain.Product;
import com.jj.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-16 23:22
 */
public class CategoryDaoImpl implements CategoryDao {
    @Override
    public List<Category> find() throws SQLException {
        String sql = "select * from category";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Category> categorys = queryRunner.query(sql, new BeanListHandler<Category>(Category.class));
        return categorys;
    }

    @Override
    public List<Product> find(String pcid) throws SQLException {
        String sql = "select * from product where pcid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Product> products = queryRunner.query(sql, new BeanListHandler<Product>(Product.class),pcid);
        return products;
    }

    @Override
    public void add(Category category) throws SQLException {
        String sql = "insert into category values(?,?)";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update(sql,category.getPcid(),category.getPcname());
    }

    @Override
    public void update(String pcid, String pcname) throws SQLException {
        String sql = "update category set pcname = ? where pcid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update(sql,pcname , pcid);
    }

    @Override
    public void delete(String pcid) throws SQLException {
        String sql = "delete from category where pcid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update(sql,pcid);
    }
}
