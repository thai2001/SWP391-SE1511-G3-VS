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
        
    /**
     *Get list of product by id of seller.All product have sid match with SellerId and quantity >= 0 will be returned
     *The result contains list of <code>Product</code> object with ProductId,BrandId,vehicleTypeId,ProductName,MadeIn,ManufactureYear,Description,Image,Quantity,UnitPrice,Discount,SellerId
     *@param sid id of seller
     *@return list <code>Product</code> object
     *@throws Exception
     */
    @Override
    public List<Product> getProductBySellerid(int sid) throws Exception {
       List<Product> list=new ArrayList<>();
        String sql="select * from Product\n" +
                   "where SellerId = ? \n" +
                   "and Quantity >= 0\n" +
                   "ORDER BY ProductId DESC ";
        
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
                p.setQuantity(rs.getInt("Quantity"));
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
    
//====================================================================================================================================================================//
    
    /**
     *Add a new Product
     *The result add a product with ProductId,BrandId,vehicleTypeId,ProductName,MadeIn,ManufactureYear,Description,Image,Quantity,UnitPrice,Discount,SellerId
     * @param vehicleTypeid     id of vehicleType
     * @param name              name of product
     * @param brandid           id of brand
     * @param madein            manufacturing place
     * @param manufactureYear   manufacturing year
     * @param descript          description of product
     * @param img               image of product
     * @param quatity           quantity of product
     * @param price             price of product
     * @param discount          discount for product
     * @param sid               id of seller
     * return 
     * @throws Exception
     */
    @Override
    public void addProduct(int vehicleTypeid, String name, int brandid, String madein, String manufactureYear, String descript, String img, int quatity, float price, float discount, int sid) throws Exception {
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
    
//====================================================================================================================================================================//
    
    //
    /**
     *Delete product by id of product
     * Update quantity = -1 =to hide product by condition quantity >=0 of method getProductBySellerid() above
     * @param pid id of product
     * return
     * @throws Exception
     */
    @Override
    public void deleteProduct(String pid) throws Exception {
        String sql = "Update Product set Quantity = -1\n" +
                     "where ProductId = ? ";
          //  String sql="delete from Product\n" +
          //          "where ProductId = ?";
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
    
//====================================================================================================================================================================//
    
    /**
     *Display product's information by id of product
     * The result contains list of <code>Product</code> object with ProductId,BrandId,vehicleTypeId,ProductName,MadeIn,ManufactureYear,Description,Image,Quantity,UnitPrice,Discount.
     * @param pid
     * @return <code>Product</code> object
     * @throws Exception
     */
    @Override
    public Product getProductByID(int pid) throws Exception{
        String sql="select * from Product\n" 
        +"where ProductId= ? ";
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
                p.setQuantity(rs.getInt("Quantity"));
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
    
//====================================================================================================================================================================//
    

    /**
     *Searching product by name and id of seller and quantity >= 0
     * The result contains list of <code>Product</code> object with ProductId,BrandId,vehicleTypeId,ProductName,MadeIn,ManufactureYear,Description,Image,Quantity,UnitPrice,Discount,SellerId
     * @param sid   id of seller
     * @param name  name of product
     * @return list <code>Product</code> object
     * @throws Exception
     */
    @Override
    public List<Product> searchProductByNameForSeller(int sid, String name) throws Exception {
        List<Product> list=new ArrayList<>();
        String sql="select * from Product\n" +
                   "where SellerId = ? \n" +
                   "and Quantity >= 0\n";
                            if(name != null){
                    
                
                sql  += " and ProductName like ? ";
    }  
                                sql+= " ORDER BY ProductId DESC ";
                            
                
        
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
                p.setQuantity(rs.getInt("Quantity"));
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
      }
          return list;
    }
    
//====================================================================================================================================================================//
    
    
    /**
     *Edit product's informations by id of product
     * The result contains list of <code>Product</code> objects with ProductId,BrandId,vehicleTypeId,ProductName,MadeIn,ManufactureYear,Description,Image,Quantity,UnitPrice,Discount
     * @param vehicleTypeId     id of vehicleType
     * @param name              name of product
     * @param Branid            id of brand
     * @param MadeIn            manufacturing place
     * @param manufactureYear   manufacturing year
     * @param description       description of product
     * @param image             image of product
     * @param quantity          quantity of product
     * @param price             price of product
     * @param discount          discount for product
     * @param id                id of product
     * return <code>Product</code> object with data updated
     * @throws Exception
     */
    @Override
    public void editProduct(int vehicleTypeId,int Branid, String name,  String MadeIn, String manufactureYear, String description, String image, int quantity, float price, float discount, int id) throws Exception {
         String sql= "update Product\n" +
"set  BrandId = ?,\n" + 
"     vehicleTypeId = ?,\n" +
"     ProductName = ?,\n" +   
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
            ps.setInt(2,Branid );
            ps.setString(3,name);
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
    //====================================================================================================================================================================//

    
       @Override
    public List<Product> getProductByPage(List<Product> list,int start,int end) throws Exception{
        List<Product> t=new ArrayList<>();
        for(int i=start;i<end;i++){
            t.add(list.get(i));
        }
        return t;
    }
    
    
    
    public static void main(String[] args) throws Exception {
         ManageProductDAO bd = new ManageProductDAO();
  
        List <Product> lp = bd.searchProductByNameForSeller(2,"");
        for(int i =0; i < lp.size();i++){
            System.out.print(lp.get(i).getName());
        }
           
    }
    
}
