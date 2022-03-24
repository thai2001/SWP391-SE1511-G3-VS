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
import dao.impl.IManageCustomerDAO;
import entity.Buyer;
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
public class ManageCustomerDAO extends DBContext implements IManageCustomerDAO {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
    @Override
    public List<Buyer> getBuyerBySellerId(int cid) throws Exception {
       
         List<Buyer> list=new ArrayList<>();
         String sql = "Select Buyer.BuyerID,\n" +
                      "       Buyer.BuyerName,\n" +
                      "	      Gmail,\n" +
                      "	   Phone\n" +
                      "FROM Buyer INNER JOIN [ORDER] on [ORDER].BuyerId = Buyer.BuyerID\n" +
                      "WHERE SellerId = ?\n" +
                      "GROUP BY Buyer.BuyerID, BuyerName, Gmail,Phone "+
                      " Order By BuyerID DESC ";
                    
        
        try{
            
            con = getConnection();
            ps= con.prepareStatement(sql);
            ps.setInt(1,cid);
            rs=ps.executeQuery();
            while(rs.next()){
                Buyer br=new Buyer(rs.getInt("BuyerID"),rs.getString("BuyerName"),rs.getString("Gmail"),rs.getString("Phone"));
                list.add(br);
            }
        }catch(Exception e){
            System.out.println(e);
        } finally{
            try {
                ps.close();
                rs.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ManageCustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
      }
       
    }

        @Override
    public List<Buyer> SearchBuyerName(int sid,String name) throws Exception {
       
         List<Buyer> list=new ArrayList<>();
         String sql = "Select Buyer.BuyerID,\n" +
                      "       Buyer.BuyerName,\n" +
                      "	      Gmail,\n" +
                      "	   Phone\n" +
                      "FROM Buyer INNER JOIN [ORDER] on [ORDER].BuyerId = Buyer.BuyerID\n" +
                      "WHERE SellerId = ?\n";
               if(name != null){
                    
                
                sql  += "AND BuyerName like ? \n" +
                         "GROUP BY Buyer.BuyerID, BuyerName, Gmail,Phone ";
    }           
               sql += " Order By BuyerID DESC ";
                      
                     

        
        try{
            
            con = getConnection();
            ps= con.prepareStatement(sql);
            ps.setInt(1,sid);
            ps.setString(2, "%"+ name +"%");
            rs=ps.executeQuery();
            while(rs.next()){
                Buyer br=new Buyer(rs.getInt("BuyerID"),rs.getString("BuyerName"),rs.getString("Gmail"),rs.getString("Phone"));
                list.add(br);
            }
        }catch(Exception e){
            System.out.println(e);
        } finally{
            try {
                ps.close();
                rs.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ManageCustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
      }
       
    }
    @Override
    public List<Buyer> getCusByPage(List<Buyer> list, int start, int end) throws Exception {
        List<Buyer> o=new ArrayList<>();
        for(int i=start;i<end;i++){
            o.add(list.get(i));
        }
        return o;
    }
    
    public static void main(String[] args) throws Exception {
        IManageCustomerDAO iManageCustomer = new ManageCustomerDAO();
        List<Buyer> listbu = iManageCustomer.getBuyerBySellerId(2);
        ManageCustomerDAO mc = new ManageCustomerDAO();
        mc.getBuyerBySellerId(2);
        for(int i =0; i < listbu.size();i++){
            System.out.print(listbu.get(i).getGmail());
        }
        
    }
  
}
