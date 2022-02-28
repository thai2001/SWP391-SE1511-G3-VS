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

import entity.Report;
import entity.ReportType;
import java.util.List;

/**
 * Chứa các interface liên quan tới các phương thức truy vấn dữ liệu
 * từ bảng Report. 
 * @author nqt26
 */
public interface IManageReportDAO {
    public List<Report> getAllReport() throws Exception;
    public List<Report> getReportByFilter(int buyerId,int productId, int typeReportId, String Sort) throws Exception;
    public List<ReportType> getAllReportType()throws Exception;
}