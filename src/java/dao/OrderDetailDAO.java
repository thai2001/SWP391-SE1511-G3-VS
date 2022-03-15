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
import dao.impl.IOderDetailDAO;
import entity.OrderDetail;
import entity.Product;
import entity.ShoppingCart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author taola
 */
public class OrderDetailDAO extends DBContext implements IOderDetailDAO {
    
    @Override
    public List<OrderDetail> getOrderBySellerId(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
        // get order detail with order id
    @Override
    public void createOrderDetail(int oid, int pid, int quantity, String from, String to) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = getConnection();
            String sql = "INSERT INTO [dbo].[OrderDetail]\n"
                    + "           ([OrderId]\n"
                    + "           ,[ProductId]\n"
                    + "           ,[Quantity]\n"
                    + "           ,[dateFrom]\n"
                    + "           ,[dateTo])\n"
                    + "     VALUES\n"
                    + "           (?,?, ?, ?, ?) ";
            ps = con.prepareStatement(sql);
            ps.setInt(1, oid);
            ps.setInt(2, pid);
            ps.setInt(3, quantity);
            ps.setString(4, from);
            ps.setString(5, to);
            ps.execute();
            
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            con.close();
        }
    }
    
    
        //delete order detail with order id and product id

    @Override
    public Vector<OrderDetail> getOrderDetailByOderId(int oid) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector vec = new Vector();
        try {
            con = getConnection();
            String sql = "select OrderId, b.ProductId,b.BrandId,b.vehicleTypeId,b.ProductName,b.MadeIn,\n"
                    + "b.ManufactureYear,b.[Description],b.[Image],b.Quantity,b.UnitPrice,b.Discount,b.SellerId,a.Quantity,a.dateFrom,a.dateTo\n"
                    + "from OrderDetail as a\n"
                    + "join Product as b on a.ProductId = b.ProductId\n"
                    + "where a.OrderId = ? ";
            ps = con.prepareStatement(sql);
            ps.setInt(1, oid);
            rs = ps.executeQuery();
            while (rs.next()) {
                vec.add(new OrderDetail(rs.getInt("OrderId"), new Product(rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getFloat(11),
                        rs.getFloat(12),
                        rs.getInt(13)), rs.getInt(14), rs.getString("dateFrom"), rs.getString("dateTo")
                ));
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
    public void deleteOrderDetail(int oid, int pid) throws Exception {
         Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = getConnection();
            String sql = "DELETE FROM [dbo].[OrderDetail]\n" +
"      WHERE ProductId = ? and OrderId = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, pid);
            ps.setInt(2, oid);
            ps.execute();
            
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            con.close();
        }
    }
    
    
    
    
     public static void main(String[] args) {
        try {
            OrderDetailDAO dao = new OrderDetailDAO();
            Vector<OrderDetail> vec = dao.getOrderDetailByOderId(3);
            for (OrderDetail orderDetail : vec) {
                System.out.println(orderDetail);
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
