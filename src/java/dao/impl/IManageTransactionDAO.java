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
import java.sql.Date;
import java.util.List;

/**
 * Interface của quản lý giao dịch chứa các phương thức truy vấn dữ liệu
 * từ database
 * <p>Bug:</p>
 * @author nqt26
 */
public interface IManageTransactionDAO {
    public List<Order> GetAllOrder ();
    public List<Order> GetOrderByCusId(int sellerId, int buyerId);
    public List<Order> GetOrderByDate(Date dateFrom,Date dateTo);
    public List<Order> GetOrderDetail(int orderId);
    public List<Order> SortOrder (String column, String sort);
}
