/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-03-11      1.0                 QuanTBA           First Implement
 */
package dao.impl;

import entity.OrderDetail;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author QuanTBA <your.name at your.org>
 */
public interface IOderDetailDAO {

    public List<OrderDetail> getOrderBySellerId(int id) throws Exception;

    //create a new order detail
    public void createOrderDetail(int oid, int pid, int quantity, String from, String to,boolean isCancle,boolean isPaid) throws Exception;

    // get order detail with order id
    public Vector<OrderDetail> getOrderDetailByOderId(int oid) throws Exception;
    
    //delete order detail with order id and product id
    public void cancelOrderDetail(int oid, int pid) throws Exception;
    
    // get order detail with order id
    public OrderDetail getOrderDetailByOP(int oid,int pid) throws Exception;
    
     public void PayOrderDetail(int oid, int pid) throws Exception;

}
