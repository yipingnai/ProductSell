package com.jj.service.impl;

import com.jj.dao.AdminDao;
import com.jj.dao.impl.AdminDaoImpl;
import com.jj.domain.Admin;
import com.jj.service.AdminService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-16 23:21
 */
public class AdminServiceImpl implements AdminService {

    @Override
    public Admin findAdmin(String anumber, String apassword) throws SQLException {
        AdminDao adminDao = new AdminDaoImpl();
        Admin admin = adminDao.findAdmin(anumber, apassword);
        return admin;
    }

    @Override
    public List<Admin> findAdminByType() throws SQLException {
        AdminDao adminDao = new AdminDaoImpl();
        List<Admin>  list = adminDao.findAdminByType();
        return list;
    }

    @Override
    public void addAdmin(Admin admin) throws SQLException {
        AdminDao adminDao = new AdminDaoImpl();
        adminDao.addAdmin(admin);
    }

    @Override
    public void updateAdminByAid(Admin admin) throws SQLException {
        AdminDao adminDao = new AdminDaoImpl();
        adminDao.updateAdminByAid(admin);
    }

    @Override
    public void deleteAdminByAid(String aid) throws SQLException {
        AdminDao adminDao = new AdminDaoImpl();
        adminDao.deleteAdminByAid(aid);
    }
}
