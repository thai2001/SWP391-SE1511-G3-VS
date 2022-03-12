/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 MinhLH           First Implement
 */
package dao;

import context.DBContext;
import dao.impl.IManageProductDao;
import dao.impl.ISellerDAO;
import entity.Account;
import entity.Product;
import entity.Seller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nqt26
 */
public class SellerDAO extends DBContext implements ISellerDAO{
      @Override
    public Seller getSeller(String username) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Seller seller = new Seller();
        try {
            con = getConnection();
            String sql = "select * from Seller\n"
                    + "where Username = ? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                seller = new Seller(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), new Account(rs.getString("username")));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return seller;
    }     

    @Override
    public int getNumberOfProductOnSale(int sellerId) throws Exception {
        List<Product> product = new ArrayList<>();
        IManageProductDao iManageProductDao = new ManageProductDAO();
        product = iManageProductDao.getProductBySellerid(sellerId);
        return product.size();
    }
}


