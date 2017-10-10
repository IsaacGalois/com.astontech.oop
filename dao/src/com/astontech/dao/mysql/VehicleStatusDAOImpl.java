package com.astontech.dao.mysql;

import com.astontech.bo.VehicleStatus;
import com.astontech.dao.VehicleStatusDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleStatusDAOImpl extends MySQL implements VehicleStatusDAO {
    @Override
    public VehicleStatus getVehicleStatusById(int vehicleStatusId) {
        Connect();
        VehicleStatus vehicleStatus = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetVehicleStatus(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, vehicleStatusId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                vehicleStatus = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return vehicleStatus;
    }

    @Override
    public List<VehicleStatus> getVehicleStatusList() {
        Connect();
        List<VehicleStatus> VehicleStatusList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetVehicleStatus(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                VehicleStatusList.add(HydrateObject(rs));
            }


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return VehicleStatusList;
    }

    @Override
    public int insertVehicleStatus(VehicleStatus vehicleStatus) {
        return 0;
    }

    @Override
    public boolean updateVehicleStatus(VehicleStatus vehicleStatus) {
        return false;
    }

    @Override
    public boolean deleteVehicleStatus(int vehicleStatusId) {
        return false;
    }

    private static VehicleStatus HydrateObject(ResultSet rs) throws SQLException{
        /*  private int VehicleStatusId;
            private int VehicleId;
            private EntityType VehicleType;
            private String Notes;
            private Date CreateDate;
        */

        //notes:    HYDRATING AN OBJECT
        VehicleStatus vehicleStatus = new VehicleStatus();
        vehicleStatus.setVehicleStatusId(rs.getInt(1));
        vehicleStatus.setVehicleId(rs.getInt(2));

        EntityTypeDAOImpl bridge = new EntityTypeDAOImpl();

        vehicleStatus.setVehicleType(bridge.getEntityTypeById(rs.getInt(3)));
        vehicleStatus.setNotes(rs.getString(4));
        vehicleStatus.setCreateDate(rs.getDate(5));

        return vehicleStatus;
    }
}
