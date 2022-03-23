/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 Thainv          First Implement
 */
package dao.impl;

import entity.Comment;
import java.util.Vector;

/**
 *
 * @author taola
 */
public interface ICommentDAO {
    // load all comment of product
    
    public Vector<Comment> getAllCommnetByPid(int pid) throws Exception;
    
    
   // get next 2 comments
    public Vector<Comment> getNext2CommnetByPid(int pid,int index) throws Exception;
    
    // get newest comments
    public Comment getNewestComment(int pid) throws Exception;
    
    // get newest comments
    public void insertNewestComment(int pid,int buyerId,String text,String date) throws Exception;
    
}
