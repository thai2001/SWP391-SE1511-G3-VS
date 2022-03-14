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
import dao.impl.IManageOrderDAO;
import entity.Brand;
import entity.Buyer;
import entity.Order;
import entity.OrderDetail;
import entity.Product;
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
 * @author QuanTBA <your.name at your.org>
 */
public class ManageOrderDAO extends DBContext implements IManageOrderDAO{
Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
    @Override
    public List<Order> getOrderBySellerId(int sid) throws Exception {
         List<Order> list=new ArrayList<>();
        String sql="Select [ORDER].OrderId, \n" +
"     Product.ProductId, \n" +
"	   Image,\n" +
"	   Product.ProductName,\n" +
"	   OrderDetail.Quantity,\n" +
"	   TotalPrice\n" +
"	   from [ORDER]  INNER JOIN OrderDetail On [ORDER].OrderId = OrderDetail.OrderId\n" +
"	                INNER JOIN Product On Product.ProductId = OrderDetail.ProductId\n" +
"	                   \n" +
"	   Where [ORDER].SellerId = ? ";
        
        try{
            
            con = getConnection();
            ps= con.prepareStatement(sql);
            ps.setInt(1,sid);
            rs=ps.executeQuery();
            while(rs.next()){
                Order od=new Order(rs.getInt("OrderId"),new Product(rs.getInt("ProductId"),rs.getString("Image"),
                                               rs.getString("ProductName")),new OrderDetail(rs.getInt("Quantity")),rs.getDouble("TotalPrice"));
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
    public Order getOrderByID(int oid) throws Exception {
        String sql="Select [ORDER].OrderId,\n" +
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
"	   Where [ORDER].OrderId = ? ";
        try{
            con = getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1,oid);
            rs=ps.executeQuery();
            while(rs.next()){
                Order od=new Order(rs.getInt("OrderId"),new Product(rs.getInt("ProductId"),rs.getString("Image"),
                                               rs.getString("ProductName")), new Buyer(rs.getString("BuyerName")),rs.getString("DateCreated"),rs.getDouble("TotalPrice"),
                                                new Brand(rs.getString("BrandName")),new OrderDetail(rs.getInt("Quantity")));
               
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

    @Override
    public List<Order> SearchOrderByDateForSeller(int sid, String datecre) throws Exception {
         List<Order> listorder = new ArrayList<>();
         String sql="Select\n" +
"    [ORDER].OrderId,\n" +
"     Product.ProductId, \n" +
"	   Image,\n" +
"	   Product.ProductName,\n" +
"	   OrderDetail.Quantity,\n" +
"	   [Order].TotalPrice\n" +
"	   from [ORDER] INNER JOIN OrderDetail On [ORDER].OrderId = OrderDetail.OrderId\n" +
"	                INNER JOIN Product On Product.ProductId = OrderDetail.ProductId\n" +	                 
"	   Where  [ORDER].SellerId = ? ";
         
         if(datecre != null){
                  sql +=" and  [ORDER].DateCreated = ? ";
         }
         try{
            con = getConnection();
            ps= con.prepareStatement(sql);
            ps.setInt(1,sid);
            ps.setString(2, datecre);
            rs=ps.executeQuery();
            while(rs.next()){
                Order od=new Order(rs.getInt("OrderId"),new Product(rs.getInt("ProductId"),rs.getString("Image"),
                                               rs.getString("ProductName")), new OrderDetail(rs.getInt("Quantity")),rs.getDouble("TotalPrice"));
            
                listorder.add(od);
            }
        }catch(Exception e){
            System.out.println(e);
        } finally{
            try {
                con.close();
                ps.close();
                rs.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(BrandDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return listorder;
      }

    
}
    
@Override
     public List<Order> getOrderByPage(List<Order> list,int start,int end) throws Exception{
        List<Order> o=new ArrayList<>();
        for(int i=start;i<end;i++){
            o.add(list.get(i));
        }
        return o;
    }
    
    public static void main(String[] args) throws Exception {
        ManageOrderDAO md = new ManageOrderDAO();
        md.SearchOrderByDateForSeller(2, "2021/07/13");
    }
}