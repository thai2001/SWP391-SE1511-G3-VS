/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 Thainv           First Implement
 */
package dao.impl;

import entity.Buyer;
import entity.Order;
import java.util.Vector;

/**
 *
 * @author thainv
 */
public interface IOrderDAO {
//    creat a new order

    public void createOrder(String date,float total, int buyerId) throws Exception;

    //get the last orderid 
    public Order getTheLastOrder() throws Exception;

    //get all order by buyer id
    public Vector<Order> getOrderByBuyerId(int buyerId) throws Exception;

    public int getNumberOfPage(int buyerId) throws Exception;

    public Vector<Order> getOrderInPage(int index, int buyerId) throws Exception;

}
