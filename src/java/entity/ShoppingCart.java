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
 * tạo các trường cho lớp ShoppingCart
 * thêm contrustor và getter,setter
 * <p>Bugs:
 * @author nqt26
 */
public class Shoppingcart {
    private Buyer buyerId;
    private Product productId;
    private int quantity;

    public Shoppingcart(Buyer buyerId, Product productId, int quantity) {
        this.buyerId = buyerId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Shoppingcart() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
