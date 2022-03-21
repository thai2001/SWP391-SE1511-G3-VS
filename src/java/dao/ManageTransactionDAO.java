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
import dao.impl.IBrandDAO;
import dao.impl.IManageTransactionDAO;
import entity.Brand;
import entity.Buyer;
import entity.Order;
import entity.OrderDetail;
import entity.Product;
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
    public List<Order> GetAllOrder() throws Exception {
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
            String sql = "  SELECT * FROM dbo.[ORDER] INNER JOIN BUYER ON"
                    + " [ORDER].BUYERID = BUYER.BUYERID ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order(rs.getInt("OrderId"), rs.getString("DateCreated"),
                        rs.getDouble("TotalPrice"), new Buyer(rs.getInt("BuyerId"), rs.getString("buyerName")), GetOrderDetail(rs.getInt("OrderId")));
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
    public List<Order> GetOrderByFilter(int orderId, int buyerId, int sellerId, Date dateFrom, Date dateTo, String sortColumn) throws Exception {
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
            String sql = "  SELECT * FROM dbo.[ORDER] INNER JOIN BUYER ON"
                    + " [ORDER].BUYERID = BUYER.BUYERID WHERE 1=1 ";
            if (orderId > 0) {
                sql += "and orderId = " + orderId + " ";
            }
            if (sellerId > 0) {
                sql += "and SellerId = " + sellerId + " ";
            }
            if (buyerId > 0) {
                sql += "and BuyerId = " + buyerId + " ";
            }
            if (dateFrom != null) {
                sql += "and DateCreated >= '" + dateFrom + "' ";
            }
            if (dateTo != null) {
                sql += "and DateCreated <= '" + dateTo + "' ";
            }
            if (!sortColumn.equals("")) {
                sql += " order by " + sortColumn + " ";
            }
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order(rs.getInt("OrderId"), rs.getString("DateCreated"),
                        rs.getDouble("TotalPrice"), new Buyer(rs.getInt("BuyerId"), rs.getString("buyerName")), GetOrderDetail(rs.getInt("OrderId")));
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
    public List<OrderDetail> GetOrderDetail(int orderId) throws Exception {
        List<OrderDetail> listOrderDetail = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        IBrandDAO ibrandDAO = new BrandDAO();
        try {
            try {
                con = getConnection();
            } catch (Exception e) {
                System.out.println("lỗi khi kết nối:" + e);
            }
            String sql = "  SELECT * FROM dbo.OrderDetail INNER JOIN dbo.Product ON \n"
                    + "  Product.ProductId = OrderDetail.ProductId INNER JOIN dbo.Brand ON\n"
                    + "  Brand.BrandId = Product.BrandId INNER JOIN dbo.Seller ON\n"
                    + "  Seller.SellerID = Product.SellerId WHERE OrderId = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();
            while (rs.next()) {
                OrderDetail orderDetail = new OrderDetail(rs.getInt("orderid"), new Product(rs.getInt("productId"),
                        rs.getString("productName"), rs.getString("image"), rs.getInt("unitprice"),
                        new Seller(rs.getInt("sellerId"), rs.getString("sellerName")),
                        new Brand(rs.getString("brandname"))), rs.getInt("quantity"));
                listOrderDetail.add(orderDetail);
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
        return listOrderDetail;
    }

    @Override
    public List<Order> GetOrderByPage(List<Order> list, int start, int end) {
        List<Order> order = new ArrayList<>();
        for (int i = start; i < end; i++) {
            order.add(list.get(i));
        }
        return order;
    }

}
