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

import entity.Buyer;
import java.util.List;

/**
 *Interface này gồm các phương thức thực hiện truy vấn và lấy dữ liệu từ bảng Buyer.
 *Trong phương thức search dữ liệu được chuẩn hoá(loại bỏ dấu cách 2 đầu) trước khi lấy ra từ cơ sở dữ liệu.
 *Các phương thức sẽ throw <code>Exception</code> nếu có bất kì lỗi xảy ra trong quá trình truy vấn, nhập liệu.
 * @author QuanTBA <your.name at your.org>
 */
public interface IManageCustomerDAO {
     public List<Buyer> getBuyerBySellerId(int id) throws Exception;
    public List<Buyer> getCusByPage(List<Buyer> list,int start,int end) throws Exception;
    public List<Buyer> SearchBuyerName(int sid,String name) throws Exception;
}
