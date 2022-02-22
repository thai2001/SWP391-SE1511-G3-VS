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
 *
 * @author Acer
 */
public interface IManageProductDao {
     public List<Product> getProductBySellerid(int sid);
     public void AddProduct(int vehicleTypeid,String name,int brandid,
                             String madein,String manufactureYear,String descript,
                              String img,int quatity,float price,float discount,
                               int sid);
     public void deleteProduct(String pid);
     public Product getProductByID(int pid);
      public void EditProduct(String Branid,String vehicleTypeId,String name,
                              String MadeIn,String manufactureYear,String description,
                              String image,String quantity,String price ,String discount,int id);
       public List<Product> SearchProductByNameForSeller(int sid,String name);
       public List<Product> getProductByUsername(String name);

}
