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
import dao.impl.IManageTransactionDAO;
import entity.Order;
import entity.Seller;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nqt26
 */
public class ManageTransactionDAO extends DBContext implements IManageTransactionDAO {

    @Override
    public List<Order> GetAllOrder() {
        List<Order> listOrder = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            try {
                con = getConnection();
            } catch (Exception e) {
                System.out.println("lỗi khi kết nối:" + e);
            }
            String sql = "  SELECT * FROM dbo.[ORDER] INNER JOIN dbo.Buyer ON Buyer.BuyerID = [ORDER].BuyerId\n"
                    + "  INNER JOIN dbo.Seller ON Seller.SellerID = [ORDER].SellerId\n"
                    + "  ORDER BY OrderId DESC";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Order order = new Order(rs.getInt("OrderId"),rs.getDate("DateCreated"), rs.getDouble("TotalPrice")
                        , new Seller(rs.getInt("SellerId")), buyerId);
            }
        } catch (SQLException se) {
            Logger.getLogger(ManageAccountDAO.class.getName()).log(Level.SEVERE, null, se);
        } finally {
            con.close;
        }
    }

    @Override
    public List<Order> GetOrderByCusId(int sellerId, int buyerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> GetOrderByDate(Date dateFrom, Date dateTo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> GetOrderDetail(int orderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> SortOrder(String column, String sort) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
