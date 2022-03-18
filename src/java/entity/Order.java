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

import java.sql.Date;
import java.util.List;

/**
 * tạo các trường cho lớp Order thêm contrustor và getter,setter
 * <p>
 * Bugs:
 *
 * @author nqt26
 */
public class Order {

    private int orderId;
    private String dateCreated;
    private double totalPrice;
    private int totalProduct;
    private Buyer buyer;
    private List<OrderDetail> listOrderDetail;

    public Order() {
    }
    
      public Order(int orderId, String dateCreated, double totalPrice, int totalProduct) {
        this.orderId = orderId;
        this.dateCreated = dateCreated;
        this.totalPrice = totalPrice;
        this.totalProduct = totalProduct;
    }
    
    
    public Order(int orderId, String dateCreated, double totalPrice) {
        this.orderId = orderId;
        this.dateCreated = dateCreated;
        this.totalPrice = totalPrice;
    }

    public Order(int orderId, String dateCreated, double totalPrice, Buyer buyer) {
        this.orderId = orderId;
        this.dateCreated = dateCreated;
        this.totalPrice = totalPrice;
        this.buyer = buyer;
    }

    public Order(int orderId, String dateCreated, double totalPrice, Buyer buyer, List<OrderDetail> listOrderdetail) {
        this.orderId = orderId;
        this.dateCreated = dateCreated;
        this.totalPrice = totalPrice;
        this.buyer = buyer;
        this.listOrderDetail = listOrderdetail;
    }


    public List<OrderDetail> getListOrderdetail() {
        return listOrderDetail;
    }

    public void setListOrderdetail(List<OrderDetail> listOrderdetail) {
        this.listOrderDetail = listOrderdetail;
    }

    public Order(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Order(String dateCreated, double totalPrice) {
        this.dateCreated = dateCreated;
        this.totalPrice = totalPrice;
    }

    public Order(int orderId, Product product, Buyer buyer, String datecreated, double totalPrice, Brand brand, OrderDetail orderdetail) {
        this.orderId = orderId;
        this.buyer = buyer;
        this.totalPrice = totalPrice;
        this.dateCreated = datecreated;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", dateCreated=" + dateCreated + ", totalPrice=" + totalPrice + ", buyer=" + buyer + totalProduct + '}';
    }

}
