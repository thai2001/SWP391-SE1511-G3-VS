/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iDao;

import entity.VehicleType;
import java.util.Vector;

/**
 *
 * @author taola
 */
public interface IVehicleTypeDao {
    public Vector<VehicleType> getAllVehicleType();
}
