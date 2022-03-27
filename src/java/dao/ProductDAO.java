/*
 * Copyright(C) 2021, group 3 SE1511JS
 * T.NET:
 *  Vehicle Store
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-02-09      1.0                 ThaiNV           Add Field
 */
package dao;

import context.DBContext;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.impl.IProductDAO;

/**
 * Lớp này có các phương thức thực hiện truy vấn hoặc cập nhật dữ liệu từ bảng
 * Product. Trong các phương thức update or insert của lớp, dữ liệu được chuẩn
 * hóa (loại bỏ dấu cách ở hai đầu) trước khi được cập nhật vào cơ sở dữ liệu
 * Các phương thức sẽ trả về một đối tượng của lớp java.lang.Exception khi có
 * bất cứ lỗi nào xảy ra trong quá trình truy vấn, cập nhật dữ liệu Bugs :
 *
 * @author Nguyen Viet Thai
 */
/**
 * The class contains method find, update, delete, insert VehicleType
 * information from Product table in database. In the update or insert method,
 * all data will be normalized (trim space) before update/insert into database
 * The method will throw an object of java.lang.Exception class if there is any
 * error occurring when finding, inserting, or updating data
 * <p>
 * Bugs:
 *
 * @author Nguyen Viet Thai
 */
public class ProductDAO extends DBContext implements IProductDAO {

    /* get all product from database ==> return a list ò product coitain : int id, int brandId, int vehicleTypeId, 
    *String name, String madeIn, String ManufactureYear, String descript, String img, int quatity, float price, float discount, int sellerId
     */
    @Override
    public Vector<Product> getAllProducts() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector vec = new Vector();
        try {
            con = getConnection();
            String sql = "SELECT * from Product"
                    + "where Quantity > 0"
                    + " order by ManufactureYear desc ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                vec.add(new Product(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getFloat(10),
                        rs.getFloat(11),
                        rs.getInt(12)
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

    /* get all product by vehicleType from database ==> return a list of product coitain : int id, int brandId, int vehicleTypeId, 
    *String name, String madeIn, String ManufactureYear, String descript, String img, int quatity, float price, float discount, int sellerId
     */
    @Override
    public Vector<Product> getAllProductsByVehicleTypeId(int vtid) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector vec = new Vector();
        try {
            con = getConnection();
            String sql = "SELECT * from Product"
                    + " where vehicleTypeId = ? "
                    + "and Quantity > 0"
                    + "order by ManufactureYear desc";
            ps = con.prepareStatement(sql);
            ps.setInt(1, vtid);
            rs = ps.executeQuery();
            while (rs.next()) {
                vec.add(new Product(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getFloat(10),
                        rs.getFloat(11),
                        rs.getInt(12)
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

    /* get all product
    vtid search follow type id  
    brand id to dearch follow brand id
    string sort to sort by option 
    from database
    ==> return a list of product coitain : int id, int brandId, int vehicleTypeId, 
    *String name, String madeIn, String ManufactureYear, String descript, String img, int quatity, float price, float discount, int sellerId
     */
    @Override
    public Vector<Product> getAllProductsWithCondition(int vtid, int brandId, String keyWord, String sort) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector vec = new Vector();
        try {
            con = getConnection();

            String sql = "select * from Product \n"
                    + "where vehicleTypeId = ? \n"
                    + "and Quantity > 0";
            if (brandId != 0) {
                sql += " and BrandId = " + brandId;
            }
            sql += " and ProductName like '%" + keyWord + "%' \n"
                    + "order by " + sort;

            ps = con.prepareStatement(sql);

            ps.setInt(1, vtid);
            rs = ps.executeQuery();
            while (rs.next()) {
                vec.add(new Product(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getFloat(10),
                        rs.getFloat(11),
                        rs.getInt(12)
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

    @Override
    public Product getProductById(int pid) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Product p = new Product();
        try {
            con = getConnection();

            String sql = "select * from Product\n"
                    + "where ProductId =  ? ";

            ps = con.prepareStatement(sql);

            ps.setInt(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = (new Product(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getFloat(10),
                        rs.getFloat(11),
                        rs.getInt(12)
                ));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return p;
    }

    /* get the number of page base on all product in database
     */
    @Override
    public int getNumberOfPage(int vtid, int brandId, String keyWord) throws Exception {
        int pageCount = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();

            String sql = "select COUNT(*) from Product \n"
                    + "where vehicleTypeId = ? \n"
                    + "and Quantity > 0";
            if (brandId != 0) {
                sql += " and BrandId = " + brandId;
            }
            sql += " and ProductName like '%" + keyWord + "%' \n";

            ps = con.prepareStatement(sql);
            ps.setInt(1, vtid);
            rs = ps.executeQuery();
            while (rs.next()) {
                pageCount = rs.getInt(1) / 9;
                if (rs.getInt(1) % 9 != 0) {
                    pageCount++;
                }
            }
        } catch (Exception ex) {
            System.out.println("Error");
        } finally {

            rs.close();
            ps.close();
            con.close();

        }
        return pageCount;
    }

    /* get the Product in page number base on all product in database
     */
    @Override
    public Vector<Product> getProductInPage(int index, int vtid, int brandId, String keyWord, String sort) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector vec = new Vector();
        try {
            con = getConnection();

            String sql = "select * from Product \n"
                    + "where vehicleTypeId = ? \n"
                      + "and Quantity > 0";
            if (brandId != 0) {
                sql += " and BrandId = " + brandId;
            }
            sql += " and ProductName like '%" + keyWord + "%' \n"
                    + "order by " + sort
                    + " OFFSET ? ROWS \n"
                    + "FETCH first 9 ROWS ONLY";

            ps = con.prepareStatement(sql);

            ps.setInt(1, vtid);
            ps.setInt(2, (index - 1) * 9);
            rs = ps.executeQuery();
            while (rs.next()) {
                vec.add(new Product(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getFloat(10),
                        rs.getFloat(11),
                        rs.getInt(12)
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

    public static void main(String[] args) throws Exception {
        ProductDAO dao = new ProductDAO();
//        Vector<Product> vec = dao.getAllProductsByVehicleTypeId(1);
//        for (Product brand : vec) {
//            System.out.println(brand);
//        }
//        Vector<Product> vec2 = dao.getAllProductsByVehicleTypeId(2);
//        for (Product brand : vec2) {
//            System.out.println(brand);
//        }
        Vector<Product> vec3 = dao.getProductInPage(1, 1, 2, "a", "ManufactureYear desc");
        for (Product brand : vec3) {
            System.out.println(brand);
        }

    

//        Product p = dao.getProductById(2);
//       
//            System.out.println(p);
    }

}
