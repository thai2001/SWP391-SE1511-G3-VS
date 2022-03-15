/*
 * Copyright(C) 2021, group 3 SE1511JS
 * T.NET:
 *  Vehicle Store
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-02-13      1.0                 TungNQ           Add Field
 */
package entity;

/**
 * tạo các trường cho lớp Report
 * thêm contrustor và getter,setter
 * <p>Bugs:
 * @author nqt26
 */
public class Report {
    private int reportId;
    private Buyer buyerId;
    private Product productId;
    private Seller seller;
    private ReportType reportTypeId;
    private String Content;

    public Report() {
    }

    public Report(int reportId, Buyer buyerId, Product productId, Seller seller,ReportType reportTypeId, String Content) {
        this.reportId = reportId;
        this.buyerId = buyerId;
        this.productId = productId;
        this.seller = seller;
        this.reportTypeId = reportTypeId;
        this.Content = Content;
    }

    public Report(int reportId, Buyer buyerId, Product productId, ReportType reportTypeId, String Content) {
        this.reportId = reportId;
        this.buyerId = buyerId;
        this.productId = productId;
        this.reportTypeId = reportTypeId;
        this.Content = Content;
    }
    

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public Buyer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Buyer buyerId) {
        this.buyerId = buyerId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public ReportType getReportTypeId() {
        return reportTypeId;
    }

    public void setReportTypeId(ReportType reportTypeId) {
        this.reportTypeId = reportTypeId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
    
}
