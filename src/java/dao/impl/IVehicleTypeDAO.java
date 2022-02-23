/*
 * Copyright(C) 2021, group 3 SE1511JS
 * T.NET:
 *  Vehicle Store
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-02-09      1.0                 ThaiNV           Add Field
 */
package dao.impl;

import entity.VehicleType;
import java.util.Vector;

/**
 *
 * @author thainv
 */
public interface IVehicleTypeDAO {

    /*
    take all vehicleType from dâtbase ==>  will return a list of VehicleType contain : vehicleTypeID, cehicleTypeName
     */
    public Vector<VehicleType> getAllVehicleType() throws Exception;
}
