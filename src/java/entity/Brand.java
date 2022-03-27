/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ThaiNV
 */
public class Brand {

    private int id;
    private String name;
    private String img;
    private String description;
    private boolean isAccepted;

    public Brand() {
    }

    public Brand(int id, String name, String img, String description, boolean isAccepted) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.description = description;
        this.isAccepted = isAccepted;
    }

    public Brand(int id, String name, String img) {
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public Brand(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    @Override
    public String toString() {
        return "Brand{" + "id=" + id + ", name=" + name + "img :  " + img + '}';
    }

}
