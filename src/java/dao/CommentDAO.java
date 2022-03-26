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

import context.DBContext;
import dao.impl.ICommentDAO;
import entity.Buyer;
import entity.Comment;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author taola
 */
public class CommentDAO extends DBContext implements ICommentDAO {

    @Override
    public Vector<Comment> getAllCommnetByPid(int pid) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector vec = new Vector();
        try {
            con = getConnection();
            String sql = "SELECT a.commentId,a.productId,b.ProductName,c.BuyerID,c.Username,a.content,a.CreatedDate\n"
                    + "  FROM [ProductComment] as a\n"
                    + "  join Product as b on a.productId = b.ProductId\n"
                    + "  join Buyer as c on a.buyerId = c.BuyerID\n"
                    + "  where a.productId = ?\n"
                    + "  order by [commentId] desc";
            ps = con.prepareStatement(sql);
            ps.setInt(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                vec.add(new Comment(rs.getInt(1), new Product(rs.getInt(2), rs.getString(3)), new Buyer(rs.getInt(4), rs.getString(5)), rs.getString(6), rs.getString(7))
                );
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return vec;
    }

    public static void main(String[] args) throws Exception {
        CommentDAO dao = new CommentDAO();
        Vector<Comment> vec = dao.getAllCommnetByPid(36);
        System.out.println(vec.size());
        for (Comment shoppingCart : vec) {
            System.out.println(shoppingCart);
        }
//        dao.addToShoppingCart(1, 15);
    }

    @Override
    public Vector<Comment> getNext2CommnetByPid(int pid, int index) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector vec = new Vector();
        try {
            con = getConnection();
            String sql = "SELECT a.commentId,a.productId,b.ProductName,c.BuyerID,c.Username,a.content,a.CreatedDate\n"
                    + "FROM [ProductComment] as a\n"
                    + "join Product as b on a.productId = b.ProductId\n"
                    + "join Buyer as c on a.buyerId = c.BuyerID\n"
                    + "where a.productId =  ? \n"
                    + "order by [commentId] desc\n"
                    + "OFFSET ? ROWS \n"
                    + "FETCH NEXT 2 ROWS ONLY";
            ps = con.prepareStatement(sql);
            ps.setInt(1, pid);
            ps.setInt(2, index);
            rs = ps.executeQuery();
            while (rs.next()) {
                vec.add(new Comment(rs.getInt(1), new Product(rs.getInt(2), rs.getString(3)), new Buyer(rs.getInt(4), rs.getString(5)), rs.getString(6), rs.getString(7))
                );
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return vec;
    }

    @Override
    public Comment getNewestComment(int pid) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Comment comment = new Comment();
        try {
            con = getConnection();
            String sql = "SELECT top(1) a.commentId,a.productId,b.ProductName,c.BuyerID,c.Username,a.content,a.CreatedDate\n"
                    + "FROM [ProductComment] as a\n"
                    + "join Product as b on a.productId = b.ProductId\n"
                    + "join Buyer as c on a.buyerId = c.BuyerID\n"
                    + "where a.productId = ? \n"
                    + "order by [commentId] desc";
            ps = con.prepareStatement(sql);
            ps.setInt(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                comment = new Comment(rs.getInt(1), new Product(rs.getInt(2), rs.getString(3)), new Buyer(rs.getInt(4), rs.getString(5)), rs.getString(6), rs.getString(7));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return comment;
    }

    @Override
    public void insertNewestComment(int pid, int buyerId, String text, String date) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();
            String sql = "INSERT INTO [dbo].[ProductComment]\n"
                    + "           ([productId]\n"
                    + "           ,[buyerId]\n"
                    + "           ,[content]\n"
                    + "           ,[CreatedDate])\n"
                    + "     VALUES\n"
                    + "           ( ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, pid);
            ps.setInt(2, buyerId);
            ps.setString(3, text);
            ps.setString(4, date);
            ps.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            con.close();
        }
    }
}
