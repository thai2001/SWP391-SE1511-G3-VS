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
import dao.impl.IManageReportDAO;
import entity.Buyer;
import entity.Product;
import entity.Report;
import entity.ReportType;
import entity.Seller;
import java.sql.Connection;
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
public class ManageReportDAO extends DBContext implements IManageReportDAO {

    @Override
    public List<Report> getAllReport() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Report> listReport = new ArrayList<>();
        try {
            try {
                con = getConnection();
            } catch (Exception ex) {
                throw ex;
            }
            String sql = " Select * from Report inner join ReportType on"
                    + " Report.TypeId = ReportType.TypeId inner join Buyer on"
                    + " Report.BuyerId = Buyer.BuyerId inner join Product on"
                    + " Report.ProductId = Product.ProductId inner join Seller on"
                    + " Seller.SellerId = Product.SellerId WHERE 1=1 ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Report report = new Report(rs.getInt("reportId"), new Buyer(rs.getInt("buyerId"), rs.getString("buyername")),
                        new Product(rs.getInt("productid"), rs.getString("productname")),
                        new Seller(rs.getInt("sellerId"), rs.getString("sellerName")),
                        new ReportType(rs.getInt("TypeId"),rs.getString("reportName")), rs.getString("content"));
                listReport.add(report);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException se) {
                throw se;
            }
        }
        return listReport;
    }

    @Override
    public List<Report> getReportByFilter(int buyerId, int productId, int typeReportId, String Sort) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Report> listReport = new ArrayList<>();
        try {
            try {
                con = getConnection();
            } catch (Exception ex) {
                System.out.println("lỗi khi kết nối:" + ex);
            }
            String sql = " Select * from Report inner join ReportType on"
                    + " Report.TypeId = ReportType.TypeId inner join Buyer on"
                    + " Report.BuyerId = Buyer.BuyerId inner join Product on"
                    + " Report.ProductId = Product.ProductId inner join Seller on"
                    + " Seller.SellerId = Product.SellerId WHERE 1=1 ";
            if (buyerId > 0) {
                sql += "and Report.buyerId = " + buyerId + " ";
            }
            if (productId > 0) {
                sql += "and Report.productId = " + productId + " ";
            }
            if (typeReportId > 0) {
                sql += "and Report.TypeId = " + typeReportId + " ";
            }
            if (Sort != null) {
                sql += "order by " + Sort + " ";
            }
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Report report = new Report(rs.getInt("reportId"), new Buyer(rs.getInt("buyerId"), rs.getString("buyername")),
                        new Product(rs.getInt("productid"), rs.getString("productname")),
                        new Seller(rs.getInt("sellerId"), rs.getString("sellerName")),
                        new ReportType(rs.getInt("TypeId"),rs.getString("reportName")), rs.getString("content"));
                listReport.add(report);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException se) {
                Logger.getLogger(ManageReportDAO.class.getName()).log(Level.SEVERE, null, se);
            }
        }
        return listReport;
    }

    @Override
    public List<ReportType> getAllReportType() throws Exception {
        List<ReportType> listReportType = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Report> listReport = new ArrayList<>();
        try {
            try {
                con = getConnection();
            } catch (Exception ex) {
                throw ex;
            }
            String sql = " Select * from ReportType ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ReportType reportType = new ReportType(rs.getInt("TypeId"), rs.getString("reportName"));
                listReportType.add(reportType);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException se) {
                throw se;
            }
        }
        return listReportType;
    }

    @Override
    public List<Report> GetreportByPage(List<Report> list, int start, int end) {
        List<Report> report = new ArrayList<>();
        for (int i = start; i < end; i++) {
            report.add(list.get(i));
        }
        return report;
        }

    @Override
    public void checkReport(int ReportId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createReport(int reportId, int buyerId, int productId, int reportTypeId, Boolean isChecked, String Content) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
