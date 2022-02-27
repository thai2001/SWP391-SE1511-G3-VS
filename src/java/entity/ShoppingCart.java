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
 * tạo các trường cho lớp ShoppingCart thêm contrustor và getter,setter
 * <p>
 * Bugs:
 *
 * @author nqt26
 */
public class ShoppingCart {

    private int buyerId;
    private Product product;

    public ShoppingCart() {
    }

    public ShoppingCart(int buyerId, Product product) {
        this.buyerId = buyerId;
        this.product = product;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "buyerId=" + buyerId + ", product=" + product.toString() + '}';
    }

}
