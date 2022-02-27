/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 ThaiNV           First Implement
 */
package dao.impl;

import entity.ShoppingCart;
import java.util.Vector;

/**
 *
 * @author thaiNV
 */
public interface IShoppingCartDAO {
    /* get all product from database in ShoppingCard tables and follow buyerID ==> return a list ò product coitain : int id, int brandId, int vehicleTypeId, 
    *String name, String madeIn, String ManufactureYear, String descript, String img, int quatity, float price, float discount, int sellerId
     */
     public Vector<ShoppingCart> getShoppingCart(int buyerId) throws Exception;
     
     
     
     
     
     /* add a new product to shopping Cart from database in ShoppingCard tables and follow buyerID ==> return a list ò product coitain : int id, int brandId, int vehicleTypeId, 
    *String name, String madeIn, String ManufactureYear, String descript, String img, int quatity, float price, float discount, int sellerId
     */
     public void addToShoppingCart(int buyerId,int pid) throws Exception;
     
     
     
     /*delete a new product to shopping Cart  database in ShoppingCard tables and follow buyerID ==> return a list ò product coitain : int id, int brandId, int vehicleTypeId, 
    *String name, String madeIn, String ManufactureYear, String descript, String img, int quatity, float price, float discount, int sellerId
     */
     
     public void deleteCart(int buyerId,int pid) throws Exception;
}
