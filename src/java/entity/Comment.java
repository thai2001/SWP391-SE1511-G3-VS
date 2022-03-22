/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 MinhLH           First Implement
 */
package entity;

/**
 *
 * @author taola
 */
public class Comment {
    private int id;
    private Product product;
    private Buyer buyer;
    private String content;
    private String date;

    public Comment() {
    }

    public Comment(int id, Product product, Buyer buyer, String content, String date) {
        this.id = id;
        this.product = product;
        this.buyer = buyer;
        this.content = content;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", product=" + product + ", buyer=" + buyer + ", content=" + content + ", date=" + date + '}';
    }
    

    
    
    
}
