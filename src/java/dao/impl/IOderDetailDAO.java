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

import entity.OrderDetail;
import java.util.List;

/**
 *
 * @author QuanTBA <your.name at your.org>
 */
public interface IOderDetailDAO {
     public List<OrderDetail> getOrderBySellerId(int id) throws Exception;
}
