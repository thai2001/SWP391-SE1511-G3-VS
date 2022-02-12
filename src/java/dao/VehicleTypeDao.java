/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.VehicleType;
import dao.impl.IVehicleTypeDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author taola
 * @version 
 * load data vehicle type from data
 */
public class VehicleTypeDao extends DBContext implements IVehicleTypeDao{
    @Override
    public Vector<VehicleType> getAllVehicleType() {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        Vector vec = new Vector();
        try {

            con = connection;
            try {
                System.out.println("Ket noi Thanh cong");
            } catch (Exception e) {
                System.out.println("Co loi khi ket noi " + e.getMessage());
            }
            String sql = "select * from vehicleType";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                vec.add(new VehicleType(rs.getInt(1),
                        rs.getString(2)
                )
                );
            }
        } catch (Exception ex) {
            System.out.println("Error");
        }
        return vec;
    }
    
    public static void main(String[] args) {
        VehicleTypeDao dao = new VehicleTypeDao();
        Vector<VehicleType> vec = dao.getAllVehicleType();
        for (VehicleType vehicleType : vec) {
            System.out.println(vehicleType);
        }
    }
}