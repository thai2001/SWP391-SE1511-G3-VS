/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 Thainv           First Implement
 */
package dao;

import context.DBContext;
import dao.impl.IOrderDAO;
import entity.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thainv
 */
public class OrderDAO extends DBContext implements IOrderDAO {

    @Override
    public void createOrder(String date, int buyerId) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();
            String sql = "INSERT INTO [dbo].[ORDER]\n"
                    + "           ([DateCreated]\n"
                    + "           ,[BuyerId])\n"
                    + "     VALUES (? ,? ) ";
            ps = con.prepareStatement(sql);
            ps.setString(1, date);
            ps.setInt(2, buyerId);
            ps.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            con.close();
        }
    }

    @Override
    public Order getTheLastOrder() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Order o = new Order();
        try {
            con = getConnection();
            String sql = "SELECT  TOP 1 *\n"
                    + "  FROM [VehicleShop].[dbo].[ORDER]\n"
                    + "  order by OrderId desc";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                o = new Order(rs.getInt(1), rs.getString(2), rs.getFloat(3));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return o;
    }

    @Override
    public Vector<Order> getOrderByBuyerId(int buyerId) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector<Order> vec = new Vector<>();
        try {
            con = getConnection();
            String sql = "SELECT * \n"
                    + "  FROM [VehicleShop].[dbo].[ORDER]\n"
                    + "    where BuyerId = ? \n"
                    + "  order by OrderId desc";
            ps = con.prepareStatement(sql);
            ps.setInt(1, buyerId);
            rs = ps.executeQuery();
            while (rs.next()) {
                vec.add(new Order(rs.getInt(1), rs.getString(2), rs.getFloat(3)));
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
    public int getNumberOfPage(int buyerId) throws Exception {
        int pageCount = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();

            String sql = "select COUNT(*) from [ORDER]\n"
                    + "where BuyerId = ? \n";

            ps = con.prepareStatement(sql);
            ps.setInt(1, buyerId);
            rs = ps.executeQuery();
            while (rs.next()) {
                pageCount = rs.getInt(1) / 10;
                if (rs.getInt(1) % 10 != 0) {
                    pageCount++;
                }
            }
        } catch (Exception ex) {
            System.out.println("Error");
        } finally {

            rs.close();
            ps.close();
            con.close();

        }
        return pageCount;
    }

    @Override
    public Vector<Order> getOrderInPage(int index, int buyerId) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector vec = new Vector();
        try {
            con = getConnection();

            String sql = "select * from [ORDER] \n"
                    + "where BuyerId = ?\n"
                    + "order by OrderId desc\n"
                    + "OFFSET ? rows\n"
                    + "fetch first 10 rows only";

            ps = con.prepareStatement(sql);

            ps.setInt(1, index);
            ps.setInt(2, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                vec.add(new Order(rs.getInt(1), rs.getString(2), rs.getFloat(3))
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

    public static void main(String[] args) {
        try {
            OrderDAO dao = new OrderDAO();
            Vector<Order> vec = dao.getOrderInPage(1,1);
            for (Order order : vec) {
                System.out.println(order);
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
