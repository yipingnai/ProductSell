package com.jj.dao.impl;

import com.jj.dao.AdminDao;
import com.jj.domain.Admin;
import com.jj.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-16 23:22
 */
public class AdminDaoImpl implements AdminDao {

    @Override
    public Admin findAdmin(String anumber, String apassword) throws SQLException {
        String sql = "select * from admin where anumber = ? and apassword =?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Admin admin = queryRunner.query(sql, new BeanHandler<Admin>(Admin.class), anumber, apassword);
        return admin;
    }

    @Override
    public List<Admin> findAdminByType() throws SQLException {
        String sql = "select * from admin";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Admin> query = queryRunner.query(sql, new BeanListHandler<Admin>(Admin.class));
        return query;
    }

    @Override
    public void addAdmin(Admin admin) throws SQLException {
        String sql = "insert into admin values(?,?,?,?,?)";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update(sql, admin.getAid(), admin.getAname(), admin.getAnumber(), admin.getApassword(),admin.getType());
    }

    @Override
    public void updateAdminByAid(Admin admin) throws SQLException {
        String sql = "update admin set aname = ?, anumber = ?, apassword = ?, type = ? where aid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update(sql, admin.getAname(), admin.getAnumber(), admin.getApassword(),admin.getType() ,admin.getAid());
    }

    @Override
    public void deleteAdminByAid(String aid) throws SQLException {
        String sql = "delete from admin where aid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update(sql, aid);
    }
}
