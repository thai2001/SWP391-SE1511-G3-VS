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

import entity.Order;
import java.util.List;

/**
 *
 * @author QuanTBA <your.name at your.org>
 */
public interface IManageOrderDAO {
    public List<Order> getOrderBySellerId(int id) throws Exception;
      public Order getOrderByID(int pid) throws Exception;
       public List<Order> SearchOrderByDateForSeller(int sid,String datecre) throws Exception;
        public List<Order> getOrderByPage(List<Order> list,int start,int end) throws Exception;
}
