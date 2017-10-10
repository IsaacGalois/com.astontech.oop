package com.astontech.dao.mysql;

import com.astontech.bo.Vehicle;
import com.astontech.bo.VehicleMake;
import com.astontech.dao.VehicleMakeDAO;
import common.helpers.DateHelper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.astontech.dao.mysql.Procedures.EXEC_VehicleMake;
import static com.astontech.dao.mysql.Procedures.GET_VehicleMake;

public class VehicleMakeDAOImpl extends MySQL implements VehicleMakeDAO {
    @Override
    public VehicleMake getVehicleMakeById(int vehicleMakeId) {
        Connect();
        VehicleMake VehicleMake = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = GET_VehicleMake;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, vehicleMakeId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                VehicleMake = HydrateObject(rs);
            }

            rs.close();

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        } finally {
            Disconnect();
        }

        return VehicleMake;
    }

    @Override
    public List<VehicleMake> getVehicleMakeList() {
        Connect();
        List<VehicleMake> VehicleMakeList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = GET_VehicleMake;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                VehicleMakeList.add(HydrateObject(rs));
            }

            rs.close();


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        } finally {
            Disconnect();
        }

        return VehicleMakeList;
    }

    @Override
    public int insertVehicleMake(VehicleMake VehicleMake) {
        Connect();
        int id = 0;

        try {                    //(QueryID, VehicleMakeId, VehicleMakeName, CreateDate)
            String sp = EXEC_VehicleMake;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setString(3, VehicleMake.getVehicleMakeName());
            cStmt.setDate(4, DateHelper.utilDateToSqlDate(VehicleMake.getCreateDate()));
            ResultSet rs = cStmt.executeQuery();

            if(rs.next())
                id = rs.getInt(1);
            else
                id = -1;

            rs.close();


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        } finally {
            Disconnect();
        }

        return id;
    }

    @Override
    public boolean updateVehicleMake(VehicleMake VehicleMake) {
        Connect();
        boolean didUpdate = false;

        try {                    //(QueryID, VehicleMakeId, VehicleMakeName, CreateDate)
            String sp = EXEC_VehicleMake;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, VehicleMake.getVehicleMakeId());
            cStmt.setString(3, VehicleMake.getVehicleMakeName());
            cStmt.setDate(4, DateHelper.utilDateToSqlDate(VehicleMake.getCreateDate()));
            ResultSet rs = cStmt.executeQuery();

            if(rs.next())
                didUpdate = true;

            rs.close();

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        } finally {
            Disconnect();
        }

        return didUpdate;
    }

    @Override
    public boolean deleteVehicleMake(int VehicleMakeId) {
        Connect();
        boolean didDelete = false;

        try {                    //(QueryID, VehicleMakeId, VehicleMakeName, CreateDate)
            String sp = EXEC_VehicleMake;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, VehicleMakeId);
            cStmt.setString(3, "");
            cStmt.setDate(4, new java.sql.Date(0));
            ResultSet rs = cStmt.executeQuery();

            if(rs.next() && rs.getInt(1) > 0)
                didDelete = true;

            rs.close();

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        } finally {
            Disconnect();
        }

        return didDelete;
    }

    private static VehicleMake HydrateObject(ResultSet rs) throws SQLException {
        /*  private int VehicleMakeId;
            private String VehicleMakeName;
            private Date CreateDate;
        */

        //notes:    HYDRATING AN OBJECT
        VehicleMake vehicleMake = new VehicleMake();
        vehicleMake.setVehicleMakeId(rs.getInt(1));
        vehicleMake.setVehicleMakeName(rs.getString(2));
        vehicleMake.setCreateDate(rs.getDate(3));

        return vehicleMake;
    }
}
