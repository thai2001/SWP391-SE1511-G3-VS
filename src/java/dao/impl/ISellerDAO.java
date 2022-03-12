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

import entity.Seller;

/**
 *
 * @author nqt26
 */
public interface ISellerDAO {

    /* Tìm kiếm Seller theo username
    * 
     */
    public Seller getSeller(String username) throws Exception;

    /* Số lượng mặt hàng đã bán
    * 
     */
    public int getNumberOfProductOnSale(int sellerId) throws Exception;
}
