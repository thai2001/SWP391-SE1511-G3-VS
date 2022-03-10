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
    private Buyer buyer;

    public Order() {
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
        return "Order{" + "orderId=" + orderId + ", dateCreated=" + dateCreated + ", totalPrice=" + totalPrice + ", buyer=" + buyer + '}';
    }

   
    
}
