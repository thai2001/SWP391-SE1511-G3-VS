/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 MinhLH           First Implement
 */
package dao.impl;

import entity.Role;
import java.util.List;

/**
 * chứa lớp interface dùng cho RoleDAO
 * <p>Bug:</p>
 * @author nqt26
 */
public interface IRoleDAO {
    public List<Role> getAllRole ();
}
