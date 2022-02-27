/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 ThaiNV           First Implement
 */
package dao;

import context.DBContext;
import dao.impl.IShoppingCartDAO;
import entity.Product;
import entity.ShoppingCart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 ** Lớp này có các phương thức thực hiện truy vấn hoặc cập nhật dữ liệu từ bảng
 * ShoppingCart. Trong các phương thức update or insert của lớp, dữ liệu được
 * chuẩn hóa (loại bỏ dấu cách ở hai đầu) trước khi được cập nhật vào cơ sở dữ
 * liệu Các phương thức sẽ trả về một đối tượng của lớp java.lang.Exception khi
 * có bất cứ lỗi nào xảy ra trong quá trình truy vấn, cập nhật dữ liệu Bugs :
 *
 * @author ThaiNV
 */
public class ShoppingCartDAO extends DBContext implements IShoppingCartDAO {

    /* get all product from database in ShoppingCard tables and follow buyerID ==> return a list ò product coitain : int id, int brandId, int vehicleTypeId, 
    *String name, String madeIn, String ManufactureYear, String descript, String img, int quatity, float price, float discount, int sellerId
     */
    @Override
    public Vector<ShoppingCart> getShoppingCart(int buyerId) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector vec = new Vector();
        try {
            con = getConnection();
            String sql = "select BuyerID, b.ProductId,b.BrandId,b.vehicleTypeId,b.ProductName,b.MadeIn,\n"
                    + "b.ManufactureYear,b.[Description],b.[Image],b.Quantity,b.UnitPrice,b.Discount,b.SellerId\n"
                    + "from ShoppingCart as a\n"
                    + "join Product as b on a.ProductId = b.ProductId\n"
                    + "where a.BuyerId = ? ";
            ps = con.prepareStatement(sql);
            ps.setInt(1, buyerId);
            rs = ps.executeQuery();
            while (rs.next()) {
                vec.add(new ShoppingCart(rs.getInt(1),
                        new Product(rs.getInt(2),
                                rs.getInt(3),
                                rs.getInt(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7),
                                rs.getString(8),
                                rs.getString(9),
                                rs.getInt(10),
                                rs.getFloat(11),
                                rs.getFloat(12),
                                rs.getInt(13))
                )
                );
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return vec;
    }

// add a new product to shopping cart list for buyer
    @Override
    public void addToShoppingCart(int buyerId, int pid) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            String sql = "INSERT INTO [dbo].[ShoppingCart]\n"
                    + "           ([BuyerId]\n"
                    + "           ,[ProductId])\n"
                    + "     VALUES\n"
                    + "           (? \n"
                    + "           ,? )";
            ps = con.prepareStatement(sql);
            ps.setInt(1, buyerId);
            ps.setInt(2, pid);
           
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            con.close();
        }
    }

    public static void main(String[] args) throws Exception {
        ShoppingCartDAO dao = new ShoppingCartDAO();
        Vector<ShoppingCart> vec = dao.getShoppingCart(1);
        System.out.println(vec.size());
        for (ShoppingCart shoppingCart : vec) {
            System.out.println(shoppingCart);
        }
        dao.addToShoppingCart(1, 25);
    }
}
