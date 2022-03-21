/*
 * Copyright(C) 2021, group 3 SE1511JS
 * T.NET:
 *  Vehicle Store
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-02-13      1.0                 TungNQ           Add Method
 */
package dao.impl;

import entity.Order;
import entity.Seller;
import java.util.List;

/**
 * chứa interface dùng cho cấp quyền người bán
 * <p>Bug:
 * @author nqt26
 */
public interface IAuthorizeSellerDAO {
    public List<Seller> getInactiveSellerAccount();
    public void denySellerAccount(String username);
    public List<Seller> GetSellerAccountByPage(List<Seller> list, int start, int end);
}
