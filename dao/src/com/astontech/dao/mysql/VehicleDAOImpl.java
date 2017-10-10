package com.astontech.dao.mysql;

import com.astontech.bo.Vehicle;
import com.astontech.dao.VehicleDAO;
import com.astontech.dao.VehicleModelDAO;
import common.helpers.DateHelper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.astontech.dao.mysql.Procedures.EXEC_Vehicle;
import static com.astontech.dao.mysql.Procedures.GET_Vehicle;

public class VehicleDAOImpl extends MySQL implements VehicleDAO {
    @Override
    public Vehicle getVehicleById(int vehicleId) {
        Connect();
        Vehicle Vehicle = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = GET_Vehicle;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, vehicleId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                Vehicle = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        } finally {
            Disconnect();
        }

        return Vehicle;
    }

    @Override
    public List<Vehicle> getVehicleList() {
        Connect();
        List<Vehicle> VehicleList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory
        ResultSet rs;

        try {
            String sp = GET_Vehicle;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            rs = cStmt.executeQuery();

            while(rs.next()) {
                VehicleList.add(HydrateObject(rs));
            }
            rs.close();

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        } finally {
            Disconnect();
        }

        return VehicleList;
    }

    @Override
    public int insertVehicle(Vehicle Vehicle) {
        Connect();
        int id = 0;

        try {                    //(QueryID, VehicleId, Year, LicensePlate, Vin, Color, IsPurchase, PurchasePrice, PurchaseDate, VehicleModelId)
            String sp = EXEC_Vehicle;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setInt(3, Vehicle.getYear());
            cStmt.setString(4, Vehicle.getLicensePlate());
            cStmt.setString(5, Vehicle.getVin());
            cStmt.setString(6, Vehicle.getColor());
            cStmt.setInt(7, Vehicle.isPurchase());
            cStmt.setInt(8, Vehicle.getPurchasePrice());
            cStmt.setDate(9, DateHelper.utilDateToSqlDate(Vehicle.getPurchaseDate()));
            cStmt.setInt(10,Vehicle.getVehicleModel().getVehicleModelId());
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
    public boolean updateVehicle(Vehicle Vehicle) {
        Connect();
        boolean didUpdate = false;

        try {                    //(QueryID, VehicleId, Year, LicensePlate, Vin, Color, IsPurchase, PurchasePrice, PurchaseDate, VehicleModelId)
            String sp = EXEC_Vehicle;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, Vehicle.getVehicleId());
            cStmt.setInt(3, Vehicle.getYear());
            cStmt.setString(4, Vehicle.getLicensePlate());
            cStmt.setString(5, Vehicle.getVin());
            cStmt.setString(6, Vehicle.getColor());
            cStmt.setInt(7, Vehicle.isPurchase());
            cStmt.setInt(8, Vehicle.getPurchasePrice());
            cStmt.setDate(9, DateHelper.utilDateToSqlDate(Vehicle.getPurchaseDate()));
            cStmt.setInt(10,Vehicle.getVehicleModel().getVehicleModelId());
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
    public boolean deleteVehicle(int VehicleId) {
        Connect();
        boolean didDelete = false;

        try {                    //(QueryID, VehicleId, Year, LicensePlate, Vin, Color, IsPurchase, PurchasePrice, PurchaseDate, VehicleModelId)
            String sp = EXEC_Vehicle;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, VehicleId);
            cStmt.setInt(3, 0);
            cStmt.setString(4, "");
            cStmt.setString(5, "");
            cStmt.setString(6, "");
            cStmt.setInt(7, 0);
            cStmt.setInt(8, 0);
            cStmt.setDate(9, new java.sql.Date(0));
            cStmt.setInt(10,0);
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

    private static Vehicle HydrateObject(ResultSet rs) throws SQLException{
        /*  private int VehicleId;
            private int Year;
            private String LicensePlate;
            private int Vin;
            private String Color;
            private boolean isPurchase;
            private double PurchasePrice;
            private Date PurchaseDate;
            private VehicleModel VehicleModel;
        */

        //notes:    HYDRATING AN OBJECT
        Vehicle Vehicle = new Vehicle();
        Vehicle.setVehicleId(rs.getInt(1));
        Vehicle.setYear(rs.getInt(2));
        Vehicle.setLicensePlate(rs.getString(3));
        Vehicle.setVin(rs.getString(4));
        Vehicle.setColor(rs.getString(5));
        Vehicle.setPurchase(rs.getInt(6));
        Vehicle.setPurchasePrice(rs.getInt(7));
        Vehicle.setPurchaseDate(rs.getDate(8));

        VehicleModelDAOImpl bridge = new VehicleModelDAOImpl();

        Vehicle.setVehicleModel(bridge.getVehicleModelById(rs.getInt(9)));

        //Took VehicleStatus out of Vehicle fields (put back?)
        return Vehicle;
    }
}
