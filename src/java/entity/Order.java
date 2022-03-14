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
    private Product product;
    private OrderDetail orderdetail;
    public Order() {
    }

    public Order(int orderId, String dateCreated, double totalPrice, Buyer buyer) {
        this.orderId = orderId;
        this.dateCreated = dateCreated;
        this.totalPrice = totalPrice;
        this.buyer = buyer;
    }

     public Order(int orderId, Product produc, OrderDetail order, double totalPrice) {
        this.orderId = orderId;
        this.product = product;
        this.orderdetail = orderdetail;
        this.totalPrice = totalPrice;
    }
public Order( double totalPrice) {
        this.totalPrice = totalPrice;
    } 

    public Order(String dateCreated, double totalPrice) {
        this.dateCreated = dateCreated;
        this.totalPrice = totalPrice;
    }

    public Order(int orderId, Product product,Buyer buyer, String datecreated,double totalPrice,Brand brand ,OrderDetail orderdetail) {
        this.orderId = orderId;
        this.product = product;
        this.buyer = buyer;
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
        return "Order{" + "orderId=" + orderId + ", dateCreated=" + dateCreated + ", totalPrice=" + totalPrice + ", buyer=" + buyer + '}';
    }

   
    
}
