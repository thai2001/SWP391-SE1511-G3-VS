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
import entity.Brand;
import entity.Buyer;
import entity.Order;
import entity.OrderDetail;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QuanTBA <your.name at your.org>
 */
public class ManageOrderDAO extends DBContext implements IOderDetailDAO{
Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
    @Override
    public List<OrderDetail> getOrderBySellerId(int sid) throws Exception {
         List<OrderDetail> list=new ArrayList<>();
        String sql="Select OrderDetail.OrderId, \n" +
"     Product.ProductId, \n" +
"	   Image,\n" +
"	   Product.ProductName,\n" +
"	   OrderDetail.Quantity,\n" +
"	   [Order].TotalPrice\n" +
"	   from OrderDetail INNER JOIN Product On Product.ProductId = OrderDetail.ProductId\n" +
"	                    INNER JOIN [ORDER] On [ORDER].OrderId = OrderDetail.OrderId\n" +
"	   Where [ORDER].SellerId = ? ";
        
        try{
            
            con = getConnection();
            ps= con.prepareStatement(sql);
            ps.setInt(1,sid);
            rs=ps.executeQuery();
            while(rs.next()){
                OrderDetail od=new OrderDetail(rs.getInt("OrderId"),new Product(rs.getInt("ProductId"),rs.getString("Image"),
                                               rs.getString("ProductName")),rs.getInt("Quantity"),new Order(rs.getDouble("TotalPrice")));
                list.add(od);
            }
        }catch(Exception e){
            System.out.println(e);
        } finally{
            try {
                ps.close();
                rs.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ManageOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
      }
       
    }

    @Override
    public OrderDetail getOrderByID(int oid) throws Exception {
        String sql="Select OrderDetail.OrderId,\n" +
"       Product.ProductName,\n" +
"	   Buyer.BuyerName,\n" +
"	   [Order].DateCreated,\n" +
"          Product.ProductId, \n" +
"	   Brand.BrandName,\n" +
"	   OrderDetail.Quantity,\n" +
"	   Image,\n" +
"	   [ORDER].TotalPrice\n" +
"	   from OrderDetail INNER JOIN Product ON OrderDetail.ProductId = Product.ProductId\n" +
"	                    INNER JOIN [ORDER] On [ORDER].OrderId = OrderDetail.OrderId\n" +
"						INNER JOIN Buyer On Buyer.BuyerID = [ORDER].BuyerId\n" +
"						INNER JOIN Brand ON Brand.BrandId = Product.BrandId\n" +
"	   Where OrderDetail.OrderId = ? ";
        try{
            con = getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1,oid);
            rs=ps.executeQuery();
            while(rs.next()){
                OrderDetail od=new OrderDetail(rs.getInt("OrderId"),new Product(rs.getInt("ProductId"),rs.getString("Image"),
                                               rs.getString("ProductName")), new Buyer(rs.getString("BuyerName")), new Order(rs.getString("DateCreated"),rs.getDouble("TotalPrice")),
                                                new Brand(rs.getString("BrandName")),rs.getInt("Quantity"));
               
                return od;
            }
        }catch(Exception e){
            System.out.println(e);
        }  finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
            Logger.getLogger(ManageProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
        
        return null; 
    }
    
}
