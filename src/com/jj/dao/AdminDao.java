package com.jj.dao;


import com.jj.domain.Admin;

import java.sql.SQLException;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-27 20:22
 */
public interface AdminDao {

    Admin findAdmin(String anumber, String apassword) throws SQLException;

    List<Admin> findAdminByType() throws SQLException;

    void addAdmin(Admin admin) throws SQLException;

    void updateAdminByAid(Admin admin) throws SQLException;

    void deleteAdminByAid(String aid) throws SQLException;
}
