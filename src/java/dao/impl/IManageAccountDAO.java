/*
 * Copyright(C) 2021, group 3 SE1511JS
 * T.NET:
 *  Vehicle Store
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-02-13      1.0                 TungNQ           Add Method
 */
package dao.impl;

import entity.Account;
import entity.Role;
import java.util.List;

/**
 * Chứa lớp interface quản lí tài khoản người dùng
 * @author nqt26
 */
public interface IManageAccountDAO {
    /**
     * Handles the <code>Search Account</code> method.
     *
     * @param roleId role of user
     * @param id servlet response
     * @throws Exception if any error occurs
     */
    public Account searchAccount(int roleId,int id) throws Exception;
    /**
     * Handles the <code>activeAccount</code> method.
     *
     * @param username username of account
     * @throws Exception if any error occurs
     */
    public void activeAccount(String username) throws Exception;
    /**
     * Handles the <code>deactiveAccount</code> method.
     *
     * @param username username of account
     * @throws Exception if any error occurs
     */
    public void deactiveAccount(String username) throws Exception;
    /**
     * Handles the <code>deactiveAccount</code> method.
     *
     * @param username username of account
     * @throws Exception if any error occurs
     */
    public String getUsernameById(int roleId,int id) throws Exception;
    
}
