/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-23      1.0                 QuanTBA          Add Method
 */
package dao;

import context.DBContext;
import dao.impl.IManageProductDao;
import entity.Brand;
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
public class ManageProductDAO extends DBContext implements IManageProductDao {
       Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
     //Lấy danh sách các sản phẩm theo ID của người bán
    /**
     *
     * @param sid
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> getProductBySellerid(int sid) throws Exception {
       List<Product> list=new ArrayList<>();
        String sql="select * from Product\n" +
                   "where SellerId = ?" ;
        
        try{
            con = getConnection();
            ps= con.prepareStatement(sql);
            ps.setInt(1,sid);
            rs=ps.executeQuery();
            while(rs.next()){
                Product p=new Product();
                p.setId(rs.getInt("ProductId"));
                p.setBrandId(rs.getInt("BrandId"));
                p.setVehicleTypeId(rs.getInt("vehicleTypeId"));
                p.setName(rs.getString("ProductName"));
                p.setMadeIn(rs.getString("MadeIn"));
                p.setManufactureYear(rs.getString("ManufactureYear"));
                p.setDescript(rs.getString("Description"));
                p.setImg(rs.getString("Image"));
                p.setQuatity(rs.getInt("Quantity"));
                p.setPrice(rs.getFloat("UnitPrice"));
                p.setDiscount(rs.getFloat("Discount"));               
                p.setSellerId(rs.getInt("SellerId"));
                list.add(p);
            }
        }catch(Exception e){
            System.out.println(e);
        } finally{
            try {
                ps.close();
                rs.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BrandDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
      }
    }

    /**
     *
     * @param vehicleTypeid
     * @param name
     * @param brandid
     * @param madein
     * @param manufactureYear
     * @param descript
     * @param img
     * @param quatity
     * @param price
     * @param discount
     * @param sid
     * @throws Exception
     */
    @Override
    public void AddProduct(int vehicleTypeid, String name, int brandid, String madein, String manufactureYear, String descript, String img, int quatity, float price, float discount, int sid) throws Exception {
        String sql="insert Product\n" +
"(vehicleTypeId,ProductName,BrandId,MadeIn,ManufactureYear,Description,Image,Quantity,UnitPrice,Discount,SellerId) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

         try{
              con = getConnection();
            ps= con.prepareStatement(sql);  
            ps.setInt(1,vehicleTypeid);
            ps.setString(2,name);
            ps.setInt(3,brandid);
            ps.setString(4,madein);
            ps.setString(5,manufactureYear);
            ps.setString(6,descript);
            ps.setString(7,img);
            ps.setInt(8,quatity);
            ps.setFloat(9,price);
            ps.setFloat(10,discount);
            ps.setInt(11,sid);
           
            ps.executeUpdate();
         }catch(Exception e){
             System.out.println(e);  
         }
         finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ManageProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
    }

    //Xoá sản phẩm theo id sản phẩm
    /**
     *
     * @param pid
     * @throws Exception
     */
    @Override
    public void deleteProduct(String pid) throws Exception {
            String sql="delete from Product\n" +
                    "where ProductId = ?";
         try{
             con = getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1,pid);
            ps.executeUpdate();
         }catch(Exception e){
             System.out.println(e);
         }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ManageProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
    }

    //Hiển thị thông tin sản phẩm dựa trên id sản phẩm
    /**
     *
     * @param pid
     * @return
     * @throws Exception
     */
    @Override
    public Product getProductByID(int pid) throws Exception{
        String sql="select * from Product\n" 
        +"where ProductId= ?";
        try{
            con = getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1,pid);
            rs=ps.executeQuery();
            while(rs.next()){
                Product p=new Product();
                p.setId(rs.getInt("ProductId"));
                p.setBrandId(rs.getInt("BrandId"));
                p.setVehicleTypeId(rs.getInt("vehicleTypeId"));
                p.setName(rs.getString("ProductName"));
                p.setMadeIn(rs.getString("MadeIn"));
                p.setManufactureYear(rs.getString("ManufactureYear"));
                p.setDescript(rs.getString("Description"));
                p.setImg(rs.getString("Image"));
                p.setQuatity(rs.getInt("Quantity"));
                p.setPrice(rs.getFloat("UnitPrice"));
                p.setDiscount(rs.getFloat("Discount"));
                return p;
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

    
    // Tìm kiếm sản phẩm theo tên

    /**
     *
     * @param sid
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> SearchProductByNameForSeller(int sid, String name) throws Exception {
        List<Product> list=new ArrayList<>();
        String sql="select * from Product\n" +
                   "where SellerId = ? " +
                   "and ProductName like ?";
        
        try{
            con = getConnection();
            ps= con.prepareStatement(sql);
            ps.setInt(1,sid);
            ps.setString(2, "%"+ name +"%");
            rs=ps.executeQuery();
            while(rs.next()){
                Product p=new Product();
                p.setId(rs.getInt("ProductId"));
                p.setBrandId(rs.getInt("BrandId"));
                p.setVehicleTypeId(rs.getInt("vehicleTypeId"));
                p.setName(rs.getString("ProductName"));
                p.setMadeIn(rs.getString("MadeIn"));
                p.setManufactureYear(rs.getString("ManufactureYear"));
                p.setDescript(rs.getString("Description"));
                p.setImg(rs.getString("Image"));
                p.setQuatity(rs.getInt("Quantity"));
                p.setPrice(rs.getFloat("UnitPrice"));
                p.setDiscount(rs.getFloat("Discount"));               
                p.setSellerId(rs.getInt("SellerId"));
                list.add(p);
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
        return list;
      }
    }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> getProductByUsername(String name) throws Exception {
       List<Product> list=new ArrayList<>();
        String sql="Select \n" +
                   "ProductId,\n" +
                   "VehicleTypeId,\n" +
                   "ProductName,\n" +
                   "BrandId,\n" +
                   "MadeIn,\n" +
                   "ManufactureYear,\n" +
                   "Product.[Description],\n" +
                   "Image,\n" +
                   "Quantity,\n" +
                   "UnitPrice,\n" +
                   "Discount,\n" +
                   "Product.SellerId\n" +
                   "FROM Product INNER JOIN Seller On Product.SellerId = Seller.SellerID\n" +
"                      INNER JOIN ACCOUNT ON ACCOUNT.Username = Seller.Username\n" +
"					  Where ACCOUNT.Username like ? ";
        
        try{
            con = getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1,"%" +name+ "%");
            rs=ps.executeQuery();
            while(rs.next()){
                Product p=new Product();
                p.setId(rs.getInt("ProductId"));
                p.setBrandId(rs.getInt("BrandId"));
                p.setVehicleTypeId(rs.getInt("vehicleTypeId"));
                p.setName(rs.getString("ProductName"));
                p.setMadeIn(rs.getString("MadeIn"));
                p.setManufactureYear(rs.getString("ManufactureYear"));
                p.setDescript(rs.getString("Description"));
                p.setImg(rs.getString("Image"));
                p.setQuatity(rs.getInt("Quantity"));
                p.setPrice(rs.getFloat("UnitPrice"));
                p.setDiscount(rs.getFloat("Discount"));               
                p.setSellerId(rs.getInt("SellerId"));
                list.add(p);
            }
        }catch(Exception e){
            System.out.println(e);
        } finally{
            try {
                ps.close();
                rs.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BrandDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
      }
    }
    
    //Chỉnh sửa thông tin sản phẩm dựa trên id sản phẩm đó
    /**
     *
     * @param vehicleTypeId
     * @param name
     * @param Branid
     * @param MadeIn
     * @param manufactureYear
     * @param description
     * @param image
     * @param quantity
     * @param price
     * @param discount
     * @param id
     * @throws Exception
     */
    @Override
    public void EditProduct(int vehicleTypeId, String name, int Branid, String MadeIn, String manufactureYear, String description, String image, int quantity, float price, float discount, int id) throws Exception {
         String sql= "update Product\n" +
"set  vehicleTypeId = ?,\n" +
"     ProductName = ?,\n" +
"     BrandId = ?,\n" +   
"     MadeIn = ?,\n" +
"     ManufactureYear = ?,\n" +
"     Description = ?,\n" +
"     Image = ?,\n" +
"     Quantity = ?,\n" +
"     UnitPrice = ?,\n" +
"     Discount = ? \n" +
"	where ProductId = ? ";
         try{
            con = getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1,vehicleTypeId);
            ps.setString(2,name );
            ps.setInt(3,Branid);
            ps.setString(4,MadeIn);
            ps.setString(5,manufactureYear);
            ps.setString(6,description);
            ps.setString(7,image);
            ps.setInt(8,quantity);
            ps.setFloat(9,price);
            ps.setFloat(10,discount);
            ps.setInt(11,id);
            ps.executeUpdate();
         }catch(Exception e){
             System.out.println(e);  
         }
        finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ManageProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
    }
    
    /**
     *
     * @param sellid
     * @param brandid
     * @return
     * @throws Exception
     */
    @Override
     public List<Product> getProductByBrandId(int sellid,int brandid) throws Exception{
        List<Product> list=new ArrayList<>();
        String sql="Select *\n" +
"       from Product \n" +
"	   where BrandId = ? \n" +
"	   and SellerId = ? ";
                
        try{
            con = getConnection();
            ps= con.prepareStatement(sql);
            ps.setInt(1,brandid);
            ps.setInt(2,sellid);
            rs=ps.executeQuery();
            while(rs.next()){
                Product p=new Product();
                p.setVehicleTypeId(rs.getInt("VehicleTypeId"));
                p.setName(rs.getString("ProductName"));
                p.setBrandId(rs.getInt("Brandid"));
                p.setMadeIn(rs.getString("MadeIn"));
                p.setManufactureYear(rs.getString("ManufactureYear"));   
                p.setDescript(rs.getString("Description"));
                p.setImg(rs.getString("Image"));
                p.setQuatity(rs.getInt("Quantity"));
                p.setPrice(rs.getFloat("UnitPrice"));
                p.setDiscount(rs.getInt("Discount"));
                p.setSellerId(rs.getInt("SellerId"));
                list.add(p);
            }
        }catch(Exception e){
            System.out.println(e);
        }   finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ManageProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
        return list;
}
    public static void main(String[] args) throws Exception {
         ManageProductDAO bd = new ManageProductDAO();
         bd.getProductByBrandId(2, 2);
           
    }
    
}
