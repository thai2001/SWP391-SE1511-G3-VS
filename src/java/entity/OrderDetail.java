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
    private String start;
    private String end;
   

  

    public OrderDetail(int orderId, Product product, int quantity, String start, String end) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.start = start;
        this.end = end;
    }

   
    
      
    public OrderDetail() {
       
    }

    public OrderDetail(int quantity) {
       this.quantity = quantity;
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
        return "OrderDetail{" + "orderId=" + orderId + ", product=" + product + ", quantity=" + quantity + ", deliverPrice="  + ", start=" + start + ", end=" + end + '}';
    }

  
    
    

    
    
}
