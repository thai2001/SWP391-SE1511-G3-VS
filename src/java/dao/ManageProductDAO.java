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
     *Lấy danh sách các sản phẩm theo ID của người bán.Tất cả sản phẩm có sid khớp với sellerid và quantity >= 0 sẽ được trả về
     *Kết quả trả về 1 list các sản phẩm với Productid,BrandId,vehicleTypeId,ProductName,MadeIn,ManufactureYear,Description,Image,Quantity,UnitPrice,Discount,SellerId
     *@param sid id của seller
     *@return list các đối tượng <code>Product</code>
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
     *Thêm mới 1 sản phẩm 
     *Kết quả sẽ thêm 1 sản phẩm mới với Productid,BrandId,vehicleTypeId,ProductName,MadeIn,ManufactureYear,Description,Image,Quantity,UnitPrice,Discount,SellerId
     * @param vehicleTypeid     id của vehicleType
     * @param name              tên sản phẩm
     * @param brandid           id của brand
     * @param madein            Nơi sản xuất
     * @param manufactureYear   Năm sản xuất
     * @param descript          Mô tả sản phẩm
     * @param img               Ảnh sản phẩm
     * @param quatity           Số lượng sản phẩm
     * @param price             Gía sản phẩm
     * @param discount          Gỉam giá
     * @param sid               id của seller
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
     *Xoá sản phẩm theo id sản phẩm
     * Cập nhật quantity = -1 để ẩn sản phẩm dựa theo điều kiện quantity >=0 của method getProductBySellerid() bên trên
     * @param pid id của sản phẩm
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
     *Hiển thị thông tin sản phẩm dựa trên id sản phẩm
     * Kết quả bao gồm đối tượng <code>Product</code> với Productid,BrandId,vehicleTypeId,ProductName,MadeIn,ManufactureYear,Description,Image,Quantity,UnitPrice,Discount.
     * @param pid
     * @return đối tượng <code>Product</code>
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
     *Tìm kiếm sản phẩm theo tên sản phẩm và id của seller và quantity >= 0
     * Kết quả bao gồm 1 list đối tượng <code>Product</code> với ProductId,BrandId,vehicleTypeId,ProductName,MadeIn,ManufactureYear,Description,Image,Quantity,UnitPrice,Discount,SellerId
     * @param sid   id của seller
     * @param name  tên sản phẩm
     * @return list các đối tượng <code>Product</code>
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
     *Chỉnh sửa thông tin sản phẩm dựa trên id sản phẩm đó
     * Kết quả bao gồm 1 đối tượng <code>Product</code> với ProductId,BrandId,vehicleTypeId,ProductName,MadeIn,ManufactureYear,Description,Image,Quantity,UnitPrice,Discount
     * @param vehicleTypeId     id của vehicleType
     * @param name              tên sản phẩm
     * @param Branid            id của brand
     * @param MadeIn            nơi sản xuất
     * @param manufactureYear   năm sản xuất
     * @param description       mô tả sản phẩm
     * @param image             ảnh sản phẩm
     * @param quantity          số lượng sản phẩm
     * @param price             giá sản phẩm
     * @param discount          giảm giá
     * @param id                id của sản phẩm
     * return đối tượng <code>Product</code> với dữ liệu được cập nhật
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
