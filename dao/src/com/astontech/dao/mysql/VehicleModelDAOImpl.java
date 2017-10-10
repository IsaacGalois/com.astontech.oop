package com.astontech.dao.mysql;

import com.astontech.bo.VehicleModel;
import com.astontech.dao.VehicleModelDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.astontech.dao.mysql.Procedures.EXEC_VehicleModel;
import static com.astontech.dao.mysql.Procedures.GET_VehicleModel;

public class VehicleModelDAOImpl extends MySQL implements VehicleModelDAO {

    @Override
    public VehicleModel getVehicleModelById(int vehicleModelId) {
        Connect();
        VehicleModel VehicleModel = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = GET_VehicleModel;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, vehicleModelId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                VehicleModel = HydrateObject(rs);
            }

            rs.close();

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        } finally {
            Disconnect();
        }

        return VehicleModel;
    }

    @Override
    public List<VehicleModel> getVehicleModelList() {
        Connect();
        List<VehicleModel> VehicleModelList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = GET_VehicleModel;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                VehicleModelList.add(HydrateObject(rs));
            }

            rs.close();


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        } finally {
            Disconnect();
        }

        return VehicleModelList;
    }

    @Override
    public int insertVehicleModel(VehicleModel VehicleModel) {
        Connect();
        int id = 0;

        try {                    //(QueryID, VehicleModelId, VehicleModelName, VehicleMakeId)
            String sp = EXEC_VehicleModel;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setString(3, VehicleModel.getVehicleModelName());
            cStmt.setInt(4, VehicleModel.getVehicleMake().getVehicleMakeId());
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
    public boolean updateVehicleModel(VehicleModel VehicleModel) {
        Connect();
        boolean didUpdate = false;

        try {                    //(QueryID, VehicleModelId, VehicleModelName, VehicleMakeId)
            String sp = EXEC_VehicleModel;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, VehicleModel.getVehicleModelId());
            cStmt.setString(3, VehicleModel.getVehicleModelName());
            cStmt.setInt(4, VehicleModel.getVehicleMake().getVehicleMakeId());
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
    public boolean deleteVehicleModel(int VehicleModelId) {
        Connect();
        boolean didDelete = false;

        try {                    //(QueryID, VehicleModelId, VehicleModelName, VehicleMakeId)
            String sp = EXEC_VehicleModel;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, VehicleModelId);
            cStmt.setString(3, "");
            cStmt.setInt(4,0);
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
    
    public VehicleModel HydrateObject(ResultSet rs) throws SQLException {
        /*  private int VehicleModelId;
            private String VehicleModelName;
            private VehicleMake VehicleMake;
        */

            //notes:    HYDRATING AN OBJECT
            VehicleModel vehicleModel = new VehicleModel();
            vehicleModel.setVehicleModelId(rs.getInt(1));
            vehicleModel.setVehicleModelName(rs.getString(2));

            VehicleMakeDAOImpl fake = new VehicleMakeDAOImpl();

            vehicleModel.setVehicleMake(fake.getVehicleMakeById(rs.getInt(3)));

            return vehicleModel;
        }

        //helper methods
        public List<VehicleModel> getVehicleModelByMakeIdList(int vehicleMakeId) {
            Connect();
            List<VehicleModel> VehicleModelByMakeIdList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

            try {
                String sp = "{call usp_GetVehicleModelWithMakeId(?)}";
                CallableStatement cStmt = connection.prepareCall(sp);

                cStmt.setInt(1, vehicleMakeId);
                ResultSet rs = cStmt.executeQuery();

                while(rs.next()) {
                    VehicleModelByMakeIdList.add(HydrateObject(rs));
                }

                rs.close();


            } catch (SQLException sqlEx) {
                logger.error(sqlEx);
            }finally {
                Disconnect();
            }

            return VehicleModelByMakeIdList;
        }
}
