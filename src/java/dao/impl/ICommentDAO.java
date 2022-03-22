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
}
