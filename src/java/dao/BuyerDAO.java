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
import dao.impl.IBuyerDAO;
import entity.Buyer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author thainv
 */
public class BuyerDAO extends DBContext implements IBuyerDAO {

    @Override
    public Buyer getBuyer(String username) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Buyer buyer = new Buyer();
        try {
            con = getConnection();
            String sql = "select * from Buyer\n"
                    + "where Username = ? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                buyer = new Buyer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return buyer;
    }

    
    public static void main(String[] args) throws Exception {
        BuyerDAO dao = new BuyerDAO();
        Buyer buyer = dao.getBuyer("thainv");
        System.out.println(buyer);
    }
}
