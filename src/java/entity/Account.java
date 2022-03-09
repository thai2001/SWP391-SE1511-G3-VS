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
 * tạo các trường cho lớp Acoount
 * thêm contrustor và getter,setter
 * <p>Bugs:
 * @author nqt26
 */
public class Account {
    private String username;
    private String password;
    private String status;
    private Role roleId;   
    private int code;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String description;

    public Account(String username, String password, String status, Role roleId) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.roleId = roleId;
    }
public Account(String username) {
    this.username = username;
}
    public Account(String username, String password, String status, Role roleId, int code, String name, String email, String phone) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.roleId = roleId;
        this.code = code;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Account(String username, String password, String status, Role roleId, int code, String name, String email, String phone, String address, String description) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.roleId = roleId;
        this.code = code;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.description = description;
    }

      
    public Account() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
