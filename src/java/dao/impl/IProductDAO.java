/*
 * Copyright(C) 2021, group 3 SE1511JS
 * T.NET:
 *  Vehicle Store
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-02-09      1.0                 ThaiNV           Add Field
 */
package dao.impl;

import entity.Product;
import java.util.Vector;

/**
 *
 * @author Thainv
 */
public interface IProductDAO {
    /* get all product from database ==> return a list ò product coitain : int id, int brandId, int vehicleTypeId, 
    *String name, String madeIn, String ManufactureYear, String descript, String img, int quatity, float price, float discount, int sellerId
     */
    public Vector<Product> getAllProducts(); 
    /* get all product by vehicleType from database ==> return a list of product coitain : int id, int brandId, int vehicleTypeId, 
    *String name, String madeIn, String ManufactureYear, String descript, String img, int quatity, float price, float discount, int sellerId
     */
    public Vector<Product> getAllProductsByVehicleTypeId(int vtid) ;
    /* get all product
    vtid search follow type id  
    brand id to dearch follow brand id
    string sort to sort by option 
    from database
    ==> return a list of product coitain : int id, int brandId, int vehicleTypeId, 
    *String name, String madeIn, String ManufactureYear, String descript, String img, int quatity, float price, float discount, int sellerId
     */
    public Vector<Product> getAllProductsWithCondition(int vtid,int brandId,String sort) ;
}
