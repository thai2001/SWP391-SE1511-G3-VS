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
import entity.Seller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.impl.IAuthorizeSellerDAO;

/**
 * Hiển thị danh sách tài khoản người bán chưa được chấp thuận Xóa thông tin
 * những tài khoản bị từ chối
 *
 * @author nqt26
 */
public class AuthorizeSellerDAO extends DBContext implements IAuthorizeSellerDAO {

    // lấy danh sách người bán chưa được cấp quyền
    @Override
    public List<Seller> getInactiveSellerAccount() {
        List<Seller> listSeller = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM dbo.ACCOUNT INNER JOIN dbo.Seller ON Seller.Username = ACCOUNT.Username \n"
                    + "INNER JOIN dbo.Role ON Role.RoleId = ACCOUNT.Role WHERE Status = 'inactive'";

            try {
                con = getConnection();
            } catch (Exception e) {
                System.out.println("Co loi khi ket noi " + e.getMessage());
            }
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Seller seller = new Seller(rs.getInt("Sellerid"),
                        rs.getString("SellerName"), rs.getString("description"), rs.getString("address"),
                        rs.getString("gmail"), rs.getString("phone"), new Account(rs.getString("username"),
                        rs.getString("password"), rs.getString("status"), new Role(rs.getInt("roleId"), rs.getString("rolename"))));
                listSeller.add(seller);
            }
        } catch (SQLException e) {
            System.out.println("" + e);
        } finally {
            try {
                ps.close();
                con.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AuthorizeSellerDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listSeller;
    }

    // từ chối yêu cầu cấp quyền và xóa thông tin
    @Override
    public void denySellerAccount(String username) {
        Connection con = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        ResultSet rs;
        try {
            String sql1 = "DELETE FROM dbo.Seller WHERE Username = ?";
            try {
                con = getConnection();
            } catch (Exception e) {
                System.out.println("Co loi khi ket noi " + e.getMessage());
            }
            ps1 = con.prepareStatement(sql1);
            ps1.setString(1, username);
            ps1.executeUpdate();
            String sql2 = "DELETE FROM dbo.ACCOUNT WHERE Username = ?";
            ps2 = con.prepareStatement(sql2);
            ps2.setString(1, username);
            ps2.executeUpdate();
        } catch (SQLException e) {
            System.out.println("" + e);
        } finally {
            try {
                ps1.close();
                ps2.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AuthorizeSellerDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        AuthorizeSellerDAO a = new AuthorizeSellerDAO();
        a.denySellerAccount("seller3");
        List<Seller> l = a.getInactiveSellerAccount();
        for (Seller s : l) {
            System.out.println(s.getSellerName() + "\n");
        }
    }
}
