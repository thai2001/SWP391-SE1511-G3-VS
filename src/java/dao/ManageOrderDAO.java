/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-03-19     1.0                  QuanTBA          Add Field
 */
package dao;

import context.DBContext;
import dao.impl.IManageOrderDAO;
import dao.impl.IManageTransactionDAO;
import entity.Buyer;
import entity.Order;
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
public class ManageOrderDAO extends DBContext implements IManageOrderDAO{
Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
  /**
     *Display detail informations of order by id of seller
     *The result contains <code>Order</code> objects with OrderId,DateCreated,TotalPrice,BuyerName.
     *@param sid   id of seller
     *@return list <code>Order</code> object
     *@throws Exception
     */
    @Override
    public List<Order> getOrderBySellerId(int sid) throws Exception {
        IManageTransactionDAO imd = new ManageTransactionDAO();
         List<Order> list=new ArrayList<>();
         String sql = "Select * from [ORDER]"
                 + "INNER JOIN Buyer ON [ORDER].BuyerId = Buyer.BuyerId "
                 + " WHERE SellerId = ? "
                 + " ORDER BY OrderId DESC ";

        try{
            
            con = getConnection();
            ps= con.prepareStatement(sql);
            ps.setInt(1,sid);
            rs=ps.executeQuery();
            while(rs.next()){
                Order od=new Order(rs.getInt("OrderId"),rs.getString("DateCreated"),rs.getDouble("TotalPrice"), new Buyer(rs.getInt("BuyerId"),rs.getString("BuyerName")),imd.GetOrderDetail(rs.getInt("OrderId")));
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
        
      }
            return list;
    }
    
    //====================================================================================================================================================================//
    
    /**
     *Display detail informations of order by id of order
     * The result contains <code>Order</code> objects with OrderId,DateCreated,TotalPrice,BuyerName.
     * @param oid id of order.
     * @return <code>Order</code> object
     * @throws Exception
     */
    @Override
    public Order getOrderByID(int oid) throws Exception {
        IManageTransactionDAO imd = new ManageTransactionDAO();
        String sql = "Select * from [ORDER]"
                 + "INNER JOIN Buyer ON [ORDER].BuyerId = Buyer.BuyerId "
                 + " WHERE OrderId = ? ";

        try{
            con = getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1,oid);
            rs=ps.executeQuery();
            while(rs.next()){
                Order od=new Order(rs.getInt("OrderId"),rs.getString("DateCreated"),rs.getDouble("TotalPrice"), new Buyer(rs.getInt("BuyerId"),rs.getString("BuyerName")),imd.GetOrderDetail(rs.getInt("OrderId")));
               
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
    
//====================================================================================================================================================================//
    
  /**
     *Searching order by date created and id of seller 
     * The result contains a list <code>Order</code> objects with OrderId,DateCreated,TotalPrice,BuyerName.
     * @param sid      id of seller
     * @param datecre  date when order created
     * @return list of <code>Order</code> objects
     * @throws Exception
     */
    @Override
    public List<Order> searchOrderByDateForSeller(int sid, String datecre) throws Exception {
         IManageTransactionDAO imd = new ManageTransactionDAO();
         List<Order> listorder = new ArrayList<>();
         String sql ="Select * from [ORDER]"
                 + "INNER JOIN Buyer ON [ORDER].BuyerId = Buyer.BuyerId "
                 + " WHERE SellerId = ? ";

         
         if(datecre != null){
                  sql += " and  [ORDER].DateCreated like ? ";
         }
            sql+= " ORDER BY OrderId DESC ";
         try{
            con = getConnection();
            ps= con.prepareStatement(sql);
            ps.setInt(1,sid);
            ps.setString(2,"%"+ datecre +"%");
            rs=ps.executeQuery();
            while(rs.next()){
                 Order od=new Order(rs.getInt("OrderId"),rs.getString("DateCreated"),rs.getDouble("TotalPrice"), new Buyer(rs.getInt("BuyerId"),rs.getString("BuyerName")),imd.GetOrderDetail(rs.getInt("OrderId")));
            
                listorder.add(od);
            }
        }catch(Exception e){
            System.out.println(e);
        } finally{
            try {
                con.close();
                ps.close();
                rs.close();
                
           }catch (SQLException ex) {
                Logger.getLogger(BrandDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
       
      }
            return listorder; 
}
    
//====================================================================================================================================================================//
    
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
        md.getOrderBySellerId(2);
        System.out.println(md.getOrderBySellerId(2).get(0).getListOrderdetail().get(0).getProduct().getName());
        
    }
}