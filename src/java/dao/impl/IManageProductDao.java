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

import entity.Brand;
import entity.Product;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface IManageProductDao  {
     public List<Product> getProductBySellerid(int sid) throws Exception;
     public void AddProduct (int vehicleTypeid,String name,int brandid,
                             String madein,String manufactureYear,String descript,
                              String img,int quatity,float price,float discount,
                               int sid) throws Exception;
     public void deleteProduct(String pid) throws Exception;
     public Product getProductByID(int pid) throws Exception;
      public void EditProduct(int vehicleTypeId,int Branid,String name,
                              String MadeIn,String manufactureYear,String description,
                              String image,int quantity,float price ,float discount,int id) throws Exception;
       public List<Product> SearchProductByNameForSeller(int sid,String name) throws Exception;
       public List<Product> getProductByUsername(String name)throws Exception;
        public List<Product> getProductByPage(List<Product> list,int start,int end) throws Exception;
     public List<Product> getProductByBrandId(int sellid,int brandid)throws Exception;
}
