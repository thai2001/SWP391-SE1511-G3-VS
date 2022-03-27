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

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class CommentQandA {

    private String name;
    private int id;
    private int idcomment;
    private String username;
    private Timestamp timecreate;
    private String content;
    private ArrayList<CommentQandA> rely = new ArrayList<CommentQandA>();
    private int roleid;
    private long timeago;
    private String dvtime;
    private int countrely;

    public CommentQandA(String name, int id, int idcomment, String username, Timestamp timecreate, String content) {
        this.name = name;
        this.id = id;
        this.idcomment = idcomment;
        this.username = username;
        this.timecreate = timecreate;
        this.content = content;
    }

    public CommentQandA(String name, int id, int idcomment, String username, Timestamp timecreate, String content, int roleid, long timeago, String dvtime) {
        this.name = name;
        this.id = id;
        this.idcomment = idcomment;
        this.username = username;
        this.timecreate = timecreate;
        this.content = content;
        this.roleid = roleid;
        this.timeago = timeago;
        this.dvtime = dvtime;
    }

    
    public CommentQandA() {
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Timestamp getTimecreate() {
        return timecreate;
    }

    public String getContent() {
        return content;
    }

    public ArrayList<CommentQandA> getRely() {
        return rely;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTimecreate(Timestamp timecreate) {
        this.timecreate = timecreate;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRely(ArrayList<CommentQandA> rely) {
        this.rely = rely;
    }

    public int getIdcomment() {
        return idcomment;
    }

    public void setIdcomment(int idcomment) {
        this.idcomment = idcomment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public long getTimeago() {
        return timeago;
    }

    public void setTimeago(long timeago) {
        this.timeago = timeago;
    }

    public String getDvtime() {
        return dvtime;
    }

    public void setDvtime(String dvtime) {
        this.dvtime = dvtime;
    }

    public int getCountrely() {
        return countrely;
    }

    public void setCountrely(int countrely) {
        this.countrely = countrely;
    }
 
    
}
