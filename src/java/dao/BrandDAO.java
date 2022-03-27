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
import entity.Brand;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.impl.IBrandDAO;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp này có các phương thức thực hiện truy vấn hoặc cập nhật dữ liệu từ bảng
 * Brand. Trong các phương thức update or insert của lớp, dữ liệu được chuẩn hóa
 * (loại bỏ dấu cách ở hai đầu) trước khi được cập nhật vào cơ sở dữ liệu Các
 * phương thức sẽ trả về một đối tượng của lớp java.lang.Exception khi có bất cứ
 * lỗi nào xảy ra trong quá trình truy vấn, cập nhật dữ liệu Bugs :
 *
 * @author Nguyen Viet Thai
 */
/**
 * The class contains method find, update, delete, insert brand information from
 * Brand table in database. In the update or insert method, all data will be
 * normalized (trim space) before update/insert into database The method wil
 * throw an object of java.lang.Exception class if there is any error occurring
 * when finding, inserting, or updating data
 * <p>
 * Bugs:
 *
 * @author Nguyen Viet Thai
 */
public class BrandDAO extends DBContext implements IBrandDAO {

    /*
    take all brand ==>  will return a list of brand contain : brandID, brandName
     */
    /**
     *
     * @return @throws Exception
     */
    @Override
    public Vector<Brand> getAllBrand() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector vec = new Vector();
        try {

            con = getConnection();

            String sql = "SELECT * \n"
                    + "  FROM [Brand]";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                vec.add(new Brand(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                )
                );
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            con.close();
        }

        return vec;
    }

    public String getBrandById(int brandId) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String brandName = "";
        try {

            con = getConnection();

            String sql = "SELECT * \n"
                    + "  FROM [Brand] WHERE Brandid = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, brandId);
            rs = ps.executeQuery();
            if (rs.next()) {
                brandName = rs.getString("brandName");
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            con.close();
        }

        return brandName;
    }

    public static void main(String[] args) throws Exception {
        BrandDAO dao = new BrandDAO();
        Vector<Brand> vec = dao.getAllBrand();
        for (Brand brand : vec) {
            System.out.println(brand);
        }
    }

    @Override
    public List<Brand> searchBrand(String brandName, String sort) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Brand> listBrand = new ArrayList<>();
        try {

            con = getConnection();

            String sql = "SELECT * \n"
                    + "  FROM [Brand] WHERE 1=1 and IsAccepted = 1 ";
            if (brandName.length() > 0) {
                sql += "and Brandname like '%" + brandName + "%' ";
            }
            if (sort.length() > 0) {
                sql += "order by " + sort + " ";
            }
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Brand brand = new Brand(rs.getInt("BrandId"), rs.getString("BrandName"), rs.getString("Img"),
                        rs.getString("Description"), rs.getBoolean("IsAccepted"));
                listBrand.add(brand);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            con.close();
        }

        return listBrand;
    }

    @Override
    public List<Brand> BrandPaging(List<Brand> list, int start, int end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Brand> getBrandRequestList() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Brand> listBrand = new ArrayList<>();
        try {

            con = getConnection();

            String sql = "SELECT * \n"
                    + "  FROM [Brand] WHERE IsAccepted = 0";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Brand brand = new Brand(rs.getInt("BrandId"), rs.getString("BrandName"), rs.getString("Img"),
                        rs.getString("Description"), rs.getBoolean("IsAccepted"));
                listBrand.add(brand);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            con.close();
        }

        return listBrand;
    }

    @Override
    public void acceptBrand(int brandId) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        try {

            con = getConnection();

            String sql = "Update Brand Set IsAccepted = 1 where BrandId = ? ";
            ps = con.prepareStatement(sql);
            ps.setInt(1, brandId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            con.close();
        }
    }

    @Override
    public void deleteBrand(int brandId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateBrand(int brandId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addBrand(String brandName, String description,String img) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
