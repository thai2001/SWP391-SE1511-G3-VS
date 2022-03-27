/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 MinhLH           First Implement
 */
package dao;

import entity.CommentQandA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import context.DBContext;
import entity.Account;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author Admin
 */
public class CommentandRelyDAO extends DBContext {

    /* get name from database ==> return a string : name or null
     */
    private CommentQandA calculateDifference(Timestamp date1, Timestamp date2) {
        long milliseconds = date1.getTime() - date2.getTime();
        long k = milliseconds / 1000;
        CommentQandA c = new CommentQandA();
        if (k / 60 > 0) {
            k = k / 60;
        } else {
            c.setDvtime("giay");
            c.setTimeago(k);
            return c;
        }

        if (k / 60 > 0) {
            k = k / 60;
        } else {
            c.setDvtime("phut");
            c.setTimeago(k);
            return c;
        }

        if (k / 24 > 0) {
            k = k / 24;
        } else {
            c.setDvtime("gio");
            c.setTimeago(k);
            return c;
        }

        if (k / 30 > 0) {
            k = k / 30;
        } else {
            c.setDvtime("ngay");
            c.setTimeago(k);
            return c;
        }

        if (k / 12 > 0) {
            k = k / 12;
        } else {
            c.setDvtime("thang");
            c.setTimeago(k);
            return c;
        }

        c.setDvtime("nam");
        c.setTimeago(k);
        return c;
    }

    /* insert comment from database ==> return a CommentQandA : comment or null
     */
    public CommentQandA InsertComment(CommentQandA c) {
        Connection con = null;
        int k = 0;
        try {
            con = getConnection();
            try {
                System.out.println("Ket noi Thanh cong");
            } catch (Exception e) {
                System.out.println("Co loi khi ket noi " + e.getMessage());
            }
            String sql = "INSERT INTO [dbo].[Comment]\n"
                    + "           ([Username]\n"
                    + "           ,[TimeCreate]\n"
                    + "           ,[Contents])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, c.getUsername());
            ps.setTimestamp(2, c.getTimecreate());
            ps.setString(3, c.getContent());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();

            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            System.out.println(id);
            c.setId(id);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return c;
    }

    /* insert rely from database ==> return a CommentQandA : comment or null
     */
    public CommentQandA InsertRely(CommentQandA c) {
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
            String sql = "INSERT INTO [dbo].[Rely]\n"
                    + "           ([IdComment]\n"
                    + "           ,[Username]\n"
                    + "           ,[TimeCreate]\n"
                    + "           ,[Contents])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, c.getIdcomment());
            ps.setString(2, c.getUsername());
            ps.setTimestamp(3, c.getTimecreate());
            ps.setString(4, c.getContent());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();

            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            System.out.println(id);
            c.setId(id);

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return c;
    }

    /* get 3 comment and 3 rely from database ==> return a ArrayList<CommentQandA> : listComment or null
     */
    public ArrayList<CommentQandA> get3Comment() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<CommentQandA> listComment = new ArrayList<CommentQandA>();
        try {
            con = getConnection();

            try {
                System.out.println("Ket noi Thanh cong");
            } catch (Exception e) {
                System.out.println("Co loi khi ket noi " + e.getMessage());
            }
            String sql = "   SELECT TOP 3 * FROM Comment ORDER BY Id DESC ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CommentQandA com = new CommentQandA();
                com.setId(rs.getInt(1));
                com.setUsername(rs.getString(2));
                Timestamp now_date = new Timestamp(System.currentTimeMillis());
                CommentandRelyDAO cdb = new CommentandRelyDAO();
                CommentQandA c = new CommentQandA();
                c = cdb.calculateDifference(now_date, rs.getTimestamp(3));
                com.setDvtime(c.getDvtime());
                com.setTimeago(c.getTimeago());
                com.setTimecreate(rs.getTimestamp(3));
                com.setContent(rs.getString(4));
                AccountDAO adb = new AccountDAO();
                Account ac = new Account();
                ac = adb.getName(com.getUsername());
                com.setName(ac.getName());
                com.setRoleid(ac.getRoleId().getRoleId());
                listComment.add(com);
                String sql1 = "   SELECT TOP 3 * FROM Rely where IdComment = ? ORDER BY Id ASC ";
                PreparedStatement ps1 = con.prepareStatement(sql1);
                ps1.setInt(1, com.getId());
                ResultSet rs1 = ps1.executeQuery();
                while (rs1.next()) {
                    CommentQandA com1 = new CommentQandA();
                    com1.setId(rs1.getInt(1));
                    com1.setUsername(rs1.getString(3));
                    com1.setTimecreate(rs1.getTimestamp(4));
                    c = cdb.calculateDifference(now_date, rs1.getTimestamp(4));
                    com1.setDvtime(c.getDvtime());
                    com1.setTimeago(c.getTimeago());
                    com1.setContent(rs1.getString(5));
                    ac = adb.getName(com1.getUsername());
                    com1.setName(ac.getName());
                    com1.setRoleid(ac.getRoleId().getRoleId());
                    com.getRely().add(com1);
                }
                sql1 = "select COUNT(IdComment) as dem\n"
                        + "  from Rely\n"
                        + "  where IdComment = ?";
                ps1 = con.prepareStatement(sql1);
                ps1.setInt(1, com.getId());
                rs1 = ps1.executeQuery();
                while (rs1.next()) {
                    com.setCountrely(rs1.getInt("dem"));
                }
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
        return listComment;
    }

    /* delete comment from database ==> not return 
     */
    public void deleteComment(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            try {
                System.out.println("Ket noi Thanh cong");
            } catch (Exception e) {
                System.out.println("Co loi khi ket noi " + e.getMessage());
            }
            String sql = "DELETE FROM [Rely]\n"
                    + "      WHERE IdComment = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

            sql = "DELETE FROM [Comment]\n"
                    + "      WHERE Id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /* delete rely from database ==> not return 
     */
    public void deleteRely(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            try {
                System.out.println("Ket noi Thanh cong");
            } catch (Exception e) {
                System.out.println("Co loi khi ket noi " + e.getMessage());
            }
            String sql = "DELETE FROM [Rely]\n"
                    + "      WHERE Id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /* edit comment and rely from database ==> not return 
     */
    public void EditComAndRel(String s, int id, String content) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            try {
                System.out.println("Ket noi Thanh cong");
            } catch (Exception e) {
                System.out.println("Co loi khi ket noi " + e.getMessage());
            }
            Timestamp now_date = new Timestamp(System.currentTimeMillis());
            if (s.equalsIgnoreCase("com")) {
                String sql = "UPDATE [dbo].[Comment]\n"
                        + "   SET [TimeCreate] = ?\n"
                        + "      ,[Contents] = ?\n"
                        + " WHERE id = ?";
                ps = con.prepareStatement(sql);
                ps.setTimestamp(1, now_date);
                ps.setString(2, content);
                ps.setInt(3, id);
                ps.execute();
            }
            if (s.equalsIgnoreCase("rel")) {
                String sql = "UPDATE [dbo].[Rely]\n"
                        + "   SET [TimeCreate] = ?\n"
                        + "      ,[Contents] = ?\n"
                        + " WHERE id = ?";
                ps = con.prepareStatement(sql);
                ps.setTimestamp(1, now_date);
                ps.setString(2, content);
                ps.setInt(3, id);
                ps.execute();
            }

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /* count comment from database ==> return a int 
     */
    public int CountComment() {
        Connection con = null;
        int k = 0;
        try {
            con = getConnection();
            try {
                System.out.println("Ket noi Thanh cong");
            } catch (Exception e) {
                System.out.println("Co loi khi ket noi " + e.getMessage());
            }
            String sql = " select COUNT(id) as dem\n"
                    + "  from Comment";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("dem");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    /* load more rely from database ==> return a ArrayList<CommentQandA> or null 
     */
    public ArrayList<CommentQandA> LoadMoreRely(int id, int exist) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<CommentQandA> listComment = new ArrayList<CommentQandA>();
        try {
            con = getConnection();
            try {
                System.out.println("Ket noi Thanh cong");
            } catch (Exception e) {
                System.out.println("Co loi khi ket noi " + e.getMessage());
            }
            String sql = "SELECT * FROM Rely\n"
                    + "where IdComment = ?\n"
                    + "order by id asc\n"
                    + "OFFSET ? ROWS \n"
                    + "FETCH FIRST 3 ROWS ONLY;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, exist);
            rs = ps.executeQuery();
            while (rs.next()) {
                CommentQandA com = new CommentQandA();
                com.setId(rs.getInt(1));
                com.setUsername(rs.getString(3));
                Timestamp now_date = new Timestamp(System.currentTimeMillis());
                CommentandRelyDAO cdb = new CommentandRelyDAO();
                CommentQandA c = new CommentQandA();
                c = cdb.calculateDifference(now_date, rs.getTimestamp(4));
                com.setDvtime(c.getDvtime());
                com.setTimeago(c.getTimeago());
                com.setTimecreate(rs.getTimestamp(4));
                com.setContent(rs.getString(5));
                AccountDAO adb = new AccountDAO();
                Account ac = new Account();
                ac = adb.getName(com.getUsername());
                com.setName(ac.getName());
                com.setRoleid(ac.getRoleId().getRoleId());
                listComment.add(com);
            }
        } catch (Exception ex) {
            System.out.println("Error ");
            return null;
        } finally {
            try {
//                rs.close();
//                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return listComment;
    }

    /* load more comment from database ==> return a ArrayList<CommentQandA> or null 
     */
    public ArrayList<CommentQandA> LoadMoreComment(int exist) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<CommentQandA> listComment = new ArrayList<CommentQandA>();
        try {
            con = getConnection();

            try {
                System.out.println("Ket noi Thanh cong");
            } catch (Exception e) {
                System.out.println("Co loi khi ket noi " + e.getMessage());
            }
            String sql = "SELECT * FROM Comment\n"
                    + "order by id DESC\n"
                    + "OFFSET ? ROWS \n"
                    + "FETCH FIRST 3 ROWS ONLY;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, exist);
            rs = ps.executeQuery();
            while (rs.next()) {
                CommentQandA com = new CommentQandA();
                com.setId(rs.getInt(1));
                com.setUsername(rs.getString(2));
                Timestamp now_date = new Timestamp(System.currentTimeMillis());
                CommentandRelyDAO cdb = new CommentandRelyDAO();
                CommentQandA c = new CommentQandA();
                c = cdb.calculateDifference(now_date, rs.getTimestamp(3));
                com.setDvtime(c.getDvtime());
                com.setTimeago(c.getTimeago());
                com.setTimecreate(rs.getTimestamp(3));
                com.setContent(rs.getString(4));
                AccountDAO adb = new AccountDAO();
                Account ac = new Account();
                ac = adb.getName(com.getUsername());
                com.setName(ac.getName());
                com.setRoleid(ac.getRoleId().getRoleId());
                listComment.add(com);
                String sql1 = "   SELECT TOP 3 * FROM Rely where IdComment = ? ORDER BY Id ASC ";
                PreparedStatement ps1 = con.prepareStatement(sql1);
                ps1.setInt(1, com.getId());
                ResultSet rs1 = ps1.executeQuery();
                while (rs1.next()) {
                    CommentQandA com1 = new CommentQandA();
                    com1.setId(rs1.getInt(1));
                    com1.setUsername(rs1.getString(3));
                    com1.setTimecreate(rs1.getTimestamp(4));
                    c = cdb.calculateDifference(now_date, rs1.getTimestamp(4));
                    com1.setDvtime(c.getDvtime());
                    com1.setTimeago(c.getTimeago());
                    com1.setContent(rs1.getString(5));
                    ac = adb.getName(com1.getUsername());
                    com1.setName(ac.getName());
                    com1.setRoleid(ac.getRoleId().getRoleId());
                    com.getRely().add(com1);
                }
                sql1 = "select COUNT(IdComment) as dem\n"
                        + "  from Rely\n"
                        + "  where IdComment = ?";
                ps1 = con.prepareStatement(sql1);
                ps1.setInt(1, com.getId());
                rs1 = ps1.executeQuery();
                while (rs1.next()) {
                    com.setCountrely(rs1.getInt("dem"));
                }
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
        return listComment;
    }
}
