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
 *Interface này gồm các phương thức thực hiện truy vấn và lấy dữ liệu từ bảng Order
 * Trong phương thức search dữ liệu được chuẩn hoá(loại bỏ dấu cách 2 đầu) trước khi lấy ra từ cơ sở dữ liệu.
 * Các phương thức sẽ throw <code>Exception</code> nếu có bất kì lỗi xảy ra trong quá trình truy vấn, nhập liệu.
 * @author QuanTBA <your.name at your.org>
 */
public interface IManageOrderDAO {
    public List<Order> getOrderBySellerId(int id) throws Exception;
      public Order getOrderByID(int pid) throws Exception;
       public List<Order> SearchOrderByDateForSeller(int sid,String datecre) throws Exception;
        public List<Order> getOrderByPage(List<Order> list,int start,int end) throws Exception;
}
