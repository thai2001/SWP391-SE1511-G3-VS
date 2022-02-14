/*
 * Copyright(C) 2021, group 3 SE1511JS
 * T.NET:
 *  Vehicle Store
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-02-13      1.0                 TungNQ           Add Method
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.impl.IManageAccountdao;

/**
 * tìm account theo vai trò và id, kích hoạt hoặc hủy kích hoạt tài khoản
 * @author nqt26
 */
public class ManageAccountdao extends DBContext implements IManageAccountdao{
    // tìm kiếm tài khoản theo vai trò và id của người dùng
    @Override
    public Account searchAccount(int roleId,int id ) {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "";

        try{
        if ( roleId == 2 ) sql = "SELECT * FROM dbo.ACCOUNT \n" +
"INNER JOIN dbo.Buyer ON Buyer.Username = ACCOUNT.Username\n" +
"INNER JOIN dbo.Role ON Role.RoleId = ACCOUNT.Role \n" +
"WHERE RoleId= ? AND BuyerID = ?  ";
        if ( roleId == 3) sql = "SELECT * FROM dbo.ACCOUNT \n" +
"INNER JOIN dbo.Seller ON Seller.Username = ACCOUNT.Username\n" +
"INNER JOIN dbo.Role ON Role.RoleId = ACCOUNT.Role \n" +
"WHERE RoleId= ? AND SellerID = ?  ";
            con = connection;
            ps = con.prepareStatement(sql);
            ps.setInt(1, roleId);
            ps.setInt(2, id);
            rs = ps.executeQuery();
           if ( rs.next()) {
                return new Account(rs.getString("username"), rs.getString("password"),rs.getString("status"),
                        new Role(rs.getInt("roleId"), rs.getString("roleName")));
            }
        } catch(SQLException e){
            System.out.println("" + e);
        } return null;
    }

    @Override
    public void activeAccount(String username) {
        Connection con;
        PreparedStatement ps;
        try {
            String sql = "UPDATE dbo.ACCOUNT SET Status = 'Active' WHERE Username = ?";
            con = connection;
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.executeUpdate();
        } catch (SQLException e){
            System.out.println("" + e);
        } finally {
            System.out.println("cap nhat thanh cong");
        }
    }

    @Override
    public void deactiveAccount(String username) {
        Connection con;
        PreparedStatement ps;
        try {
            String sql = "UPDATE dbo.ACCOUNT SET Status = 'Active' WHERE Username = ?";
            con = connection;
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.executeUpdate();
        } catch (SQLException e){
            System.out.println("" + e);
        } finally {
            System.out.println("cap nhat thanh cong");
        }
    }

    
}
