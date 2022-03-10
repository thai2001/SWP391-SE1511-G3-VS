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

/**
 * tạo các trường cho lớp Order
 * thêm contrustor và getter,setter
 * <p>Bugs:
 * @author nqt26
 */
public class Order {
    private int orderId;
    private String dateCreated;
    private double totalPrice;
    private int buyerId;

    public Order() {
    }

    public Order(int orderId, String dateCreated, double totalPrice, int buyerId) {
        this.orderId = orderId;
        this.dateCreated = dateCreated;
        this.totalPrice = totalPrice;
        this.buyerId = buyerId;
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

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", dateCreated=" + dateCreated + ", totalPrice=" + totalPrice + ", buyerId=" + buyerId + '}';
    }
    
}
