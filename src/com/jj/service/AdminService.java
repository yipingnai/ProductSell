package com.jj.service;


import com.jj.domain.Admin;

import java.sql.SQLException;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-16 23:19
 */
public interface AdminService {

    Admin findAdmin(String anumber, String apassword) throws SQLException;

    List<Admin> findAdminByType() throws SQLException;

    void addAdmin(Admin admin) throws SQLException;

    void updateAdminByAid(Admin admin) throws SQLException;

    void deleteAdminByAid(String aid) throws SQLException;
}
