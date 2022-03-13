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
 * tạo các trường cho lớp OrderDetail
 * thêm contrustor và getter,setter
 * <p>Bugs:
 * @author nqt26
 */
public class OrderDetail {
    private int orderId;
    private Product product;
    private int quantity;
    private float deliverPrice;
    private String start;
    private String end;
    private Order order;
    private Buyer buyer;
    private Brand brand;

  

    public OrderDetail(int orderId, Product product, int quantity, float deliverPrice, String start, String end) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.deliverPrice = deliverPrice;
        this.start = start;
        this.end = end;
    }

    public OrderDetail(int orderId, Product product, int quantity, Order order) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.order = order;
    }
    
        public OrderDetail(int orderId, Product product,Buyer buyer,  Order order,Brand brand ,int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.buyer = buyer;
        this.order = order;
        this.brand = brand;
        this.quantity = quantity;
        
    }
    public OrderDetail() {
       
    }

    
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
      public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
   
    public float getDeliverPrice() {
        return deliverPrice;
    }

    public void setDeliverPrice(float deliverPrice) {
        this.deliverPrice = deliverPrice;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    

    @Override
    public String toString() {
        return "OrderDetail{" + "orderId=" + orderId + ", product=" + product + ", quantity=" + quantity + ", deliverPrice=" + deliverPrice + ", start=" + start + ", end=" + end + '}';
    }

  
    
    

    
    
}
