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
import java.util.logging.Logger;

/**
 * tạo các trường cho lớp Buyer
 * thêm contrustor và getter,setter
 * <p>Bugs:
 * @author nqt26
 */
public class Buyer {
    private int buyerId;
    private String buyerName;
    private String address;
    private String gmail;
    private String phone;
    private Date birthday;
    private String username;

    public Buyer() {
    }

    public Buyer(int buyerId, String buyerName, String address, String gmail, String phone, Date birthday, String username) {
        this.buyerId = buyerId;
        this.buyerName = buyerName;
        this.address = address;
        this.gmail = gmail;
        this.phone = phone;
        this.birthday = birthday;
        this.username = username;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
}
