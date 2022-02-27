/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 Thainv           First Implement
 */
package dao.impl;

import entity.Buyer;

/**
 *
 * @author thainv
 */
public interface IBuyerDAO {
//    get a buyer from username
     public Buyer getBuyer(String username) throws Exception;
}
