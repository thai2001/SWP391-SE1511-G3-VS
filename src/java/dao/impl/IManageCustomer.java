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
 *
 * @author QuanTBA <your.name at your.org>
 */
public interface IManageCustomer {
    public List<Buyer> getBuyerBySellerId(int id) throws Exception;
    public List<Buyer> getCusByPage(List<Buyer> list,int start,int end) throws Exception;
}
