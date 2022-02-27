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
                    + " Report.TypeId = ReportType.TypeId";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Report report = new Report(rs.getInt("reportId"), new Buyer(rs.getInt("buyerId")),
                        new Product(rs.getInt("productid")), new ReportType(rs.getInt("TypeId"),
                                rs.getString("reportName")), rs.getString("content"));
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
    public List<Report> getReportByFilter( int buyerId, int productId, int typeReportId, String Sort) throws Exception {
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
                    + " Report.ReportTypeId = ReportType.ReportTypeId WHERE 1=1 ";
            if (buyerId > 0) {
                sql += "and buyerId = " + buyerId + " ";
            }
            if (productId > 0) {
                sql += "and productId = " + productId + " ";
            }
            if (typeReportId > 0) {
                sql += "and ReportTypeId = " + typeReportId + " ";
            }
            if (!Sort.isEmpty()) {
                sql += "order by " + Sort + " ";
            }
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Report report = new Report(rs.getInt("reportId"), new Buyer(rs.getInt("buyerId")),
                        new Product(rs.getInt("productid")), new ReportType(rs.getInt("TypeId"),
                                rs.getString("reportName")), rs.getString("content"));
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
}
