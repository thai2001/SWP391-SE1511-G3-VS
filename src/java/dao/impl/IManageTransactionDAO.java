/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 MinhLH           First Implement
 */
package dao.impl;

import entity.Order;
import entity.OrderDetail;
import java.sql.Date;
import java.util.List;

/**
 * Interface của quản lý giao dịch chứa các phương thức truy vấn dữ liệu bảng order
 * từ database. Khi gặp lỗi sẽ throw <code>Exception</code> cho servlet
 * <p>Bug:</p>
 * @author nqt26
 */
public interface IManageTransactionDAO {
    public List<Order> GetAllOrder () throws Exception;
    public List<Order> GetOrderByFilter(int orderId, int sellerId, int buyerId, Date dateFrom, Date dateTo, String sortColunm) throws Exception;
    public List<OrderDetail> GetOrderDetail(int orderId) throws Exception;
}
