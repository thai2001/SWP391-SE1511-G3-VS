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
import dao.impl.IManageTransactionDAO;
import entity.Buyer;
import entity.Order;
import entity.OrderDetail;
import entity.Seller;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nqt26
 */
public class ManageTransactionDAO extends DBContext implements IManageTransactionDAO {

    @Override
    public List<Order> GetAllOrder() throws Exception{
        List<Order> listOrder = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            try {
                con = getConnection();
            } catch (Exception e) {
                System.out.println("lỗi khi kết nối:" + e);
            }
            String sql = "  SELECT * FROM dbo.[ORDER] ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Order order = new Order(rs.getInt("OrderId"),rs.getString("DateCreated"), rs.getDouble("TotalPrice")
                        , new Buyer(rs.getInt("BuyerId")));
                listOrder.add(order);
            }
        } catch (SQLException se) {
            throw se;
        } finally {            
            try {
                rs.close();
                ps.close();
                con.close();                
            } catch (SQLException ex) {
                Logger.getLogger(ManageTransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listOrder;
    }

    @Override
    public List<Order> GetOrderByFilter(int orderId, int buyerId,Date dateFrom, Date dateTo,String sortColumn) throws Exception{
        List<Order> listOrder = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            try {
                con = getConnection();
            } catch (Exception e) {
                System.out.println("lỗi khi kết nối:" + e);
            }
            String sql = "  SELECT * FROM dbo.[ORDER] WHERE 1=1 ";
            if (orderId > 0) {
                sql += "and orderId = " + orderId + " ";
            }           
            if ( buyerId > 0 ) { sql += "and BuyerId = " + buyerId + " "; }
            if ( dateFrom != null) { sql += "and DateCreated >= '" + dateFrom + "' "; }
            if ( dateTo != null) { sql += "and DateCreated <= '" + dateTo + "' "; }
            if ( sortColumn != null ) { sql += " order by " + sortColumn + " "; } 
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Order order = new Order(rs.getInt("OrderId"),rs.getString("DateCreated"), 
                        rs.getDouble("TotalPrice"), new Buyer(rs.getInt("BuyerId"))) ;
                listOrder.add(order);
            }
        } catch (SQLException se) {
            throw se;
        } finally {            
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ManageTransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listOrder;
        
    }


    @Override
    public List<OrderDetail> GetOrderDetail(int orderId) {
               List<OrderDetail> listOrderDetail = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            try {
                con = getConnection();
            } catch (Exception e) {
                System.out.println("lỗi khi kết nối:" + e);
            }
            String sql = "  SELECT * FROM dbo.[ORDER] a INNERJOIN dbo.[ORDERDETAIL] b ON a.orderID = b.orderID"
                    + "INNERJOIN dbo.[SELLER] c ON b.ProductID = c.ProductID  WHERE 1=1 ";
            if (orderId > 0) {
                sql += "and orderId = " + orderId + " ";
            }
            if ( sellerId > 0 ) { sql += "and SellerId = " + sellerId +" "; }
            if ( buyerId > 0 ) { sql += "and BuyerId = " + buyerId + " "; }
            if ( dateFrom != null) { sql += "and DateCreated >= '" + dateFrom + "' "; }
            if ( dateTo != null) { sql += "and DateCreated <= '" + dateTo + "' "; }
            if ( sortColumn != null ) { sql += " order by " + sortColumn + " "; } 
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                OrderDetail orderDetail = new OrderDetail(rs.getInt(), product, orderId, orderId, sql, sql);
                listOrder.add(order);
            }
        } catch (SQLException se) {
            throw se;
        } finally {            
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ManageTransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listOrder;     
    }
}
