/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Account;
import entity.Buyer;
import entity.Product;
import entity.Role;
import entity.Seller;
import java.sql.Connection;
import java.util.Vector;

/**
 *
 * @author levan
 */
/**
 * Lớp này có các phương thức thực hiện truy vấn hoặc cập nhật dữ liệu từ bảng
 * Account. Trong các phương thức select or insert của lớp, dữ liệu được chuẩn
 * hóa (loại bỏ dấu cách ở hai đầu) trước khi được cập nhật vào cơ sở dữ liệu
 * Các phương thức sẽ trả về một đối tượng của lớp java.lang.Exception khi có
 * bất cứ lỗi nào xảy ra trong quá trình truy vấn, cập nhật dữ liệu Bugs :
 *
 * @author levan
 */
public class AccountDAO extends DBContext {

    /* get account from database ==> return a account coitain : string ussername, string password, string email, 
    *String status, int rolid,
     */
    public Account getAccount(Account a) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Account ac = null;
        try {
            con = getConnection();

            try {
                System.out.println("Ket noi Thanh cong");
            } catch (Exception e) {
                System.out.println("Co loi khi ket noi " + e.getMessage());
            }
            String sql = " select * from Account\n"
                    + "where [username] = ? and [password] = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, a.getUsername());
            ps.setString(2, a.getPassword());
            rs = ps.executeQuery();
            while (rs.next()) {
                ac = new Account();
                ac.setUsername(rs.getString(1));
                ac.setPassword(rs.getString(2));
                ac.setCode(rs.getInt("Code"));
                ac.setRoleId(new Role(rs.getInt("Role")));
                ac.setStatus(rs.getString("Status"));
            }
        } catch (Exception ex) {
            System.out.println("Error ");
            return null;
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return ac;
    }

    /* insert account from database ==> return a string : "oke" or "not oke"
     */
    public String Insert(Account a) {
        Connection con = null;
        PreparedStatement ps = null;
        int k = 0;
        try {
            con = getConnection();
            try {
                System.out.println("Ket noi Thanh cong");
            } catch (Exception e) {
                System.out.println("Co loi khi ket noi " + e.getMessage());
            }
            con.setAutoCommit(false);
            String sql = "INSERT INTO [dbo].[ACCOUNT]\n"
                    + "           ([Username]\n"
                    + "           ,[Password]\n"
                    + "           ,[Status]\n"
                    + "           ,[Role]\n"
                    + "           ,[Code])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, a.getUsername());
            ps.setString(2, a.getPassword());
            ps.setString(3, a.getStatus());
            ps.setInt(4, a.getRoleId().getRoleId());
            ps.setInt(5, a.getCode());
            ps.executeUpdate();

            k = 1;
            if (a.getRoleId().getRoleId() == 1) {
                sql = "INSERT INTO [dbo].[Buyer]\n"
                        + "           ([BuyerName]\n"
                        + "           ,[Gmail]\n"
                        + "           ,[Phone]\n"
                        + "           ,[Username])\n"
                        + "     VALUES\n"
                        + "           (?\n"
                        + "           ,?\n"
                        + "           ,?\n"
                        + "           ,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, a.getName());
                ps.setString(2, a.getEmail());
                ps.setString(3, a.getPhone());
                ps.setString(4, a.getUsername());
                ps.executeUpdate();
            } else {
                sql = "INSERT INTO [dbo].[Seller]\n"
                        + "           ([SellerName]\n"
                        + "           ,[Description]\n"
                        + "           ,[Address]\n"
                        + "           ,[Gmail]\n"
                        + "           ,[Phone]\n"
                        + "           ,[Username])\n"
                        + "     VALUES\n"
                        + "           (?\n"
                        + "           ,?\n"
                        + "           ,?\n"
                        + "           ,?\n"
                        + "           ,?\n"
                        + "           ,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, a.getName());
                ps.setString(2, a.getDescription());
                ps.setString(3, a.getAddress());
                ps.setString(4, a.getEmail());
                ps.setString(5, a.getPhone());
                ps.setString(6, a.getUsername());
                ps.executeUpdate();
            }
            con.commit();
        } catch (Exception ex) {
            System.out.println(ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            if (k == 0) {
                return "AccountExit";
            } else {
                return "GmailExit";
            }
        } finally {
            try {
                con.setAutoCommit(true);
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "oke";
    }

    /* Update code from database"
     */
    public void updateCode(Account a) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Account ac = null;
        try {
            con = getConnection();
            try {
                System.out.println("Ket noi Thanh cong");
            } catch (Exception e) {
                System.out.println("Co loi khi ket noi " + e.getMessage());
            }
            String sql = " UPDATE [dbo].[ACCOUNT]\n"
                    + "   SET [Code] = 0\n"
                    + " WHERE username = ?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, a.getUsername());
            ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Error ");
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
