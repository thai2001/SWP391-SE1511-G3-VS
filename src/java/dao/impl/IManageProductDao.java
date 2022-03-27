/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-14      1.0                 QuanTBA          First Implement
 */
package dao.impl; 
import entity.Product;
import java.util.List;

/**
 *Chứa các interface quản lí các sản phẩm đang bán gồm các phương thức được truy vấn từ bảng dữ liệu Product.
 * Trong các phương thức add,edit,search dữ liệu được chuẩn hoá(loại bỏ dấu cách 2 đầu) trước khi cập nhật vào cơ sở dữ liệu
 * Các phương thức sẽ throw <code>Exception</code> nếu có bất kì lỗi xảy ra trong quá trình truy vấn, nhập liệu
 * <p>Bugs:</p>
 * @author QuanTBA
 */
public interface IManageProductDao  {
     public List<Product> getProductBySellerid(int sid) throws Exception;
     
     public void addProduct (int vehicleTypeid,String name,int brandid,
                              String madein,String manufactureYear,String descript,
                              String img,int quatity,float price,float discount,
                              int sid) throws Exception;
     public void deleteProduct(String pid) throws Exception;
     public Product getProductByID(int pid) throws Exception;
      public void editProduct(int vehicleTypeId,int Branid,String name,
                              String MadeIn,String manufactureYear,String description,
                              String image,int quantity,float price ,float discount,int id) throws Exception;
       public List<Product> searchProductByNameForSeller(int sid,String name) throws Exception;
       
        public List<Product> getProductByPage(List<Product> list,int start,int end) throws Exception;
    
}
