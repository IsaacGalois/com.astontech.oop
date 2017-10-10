package com.astontech.dao;

import com.astontech.bo.VehicleStatus;

import java.util.List;

public interface VehicleStatusDAO {
    //notes: GET methods
    public VehicleStatus getVehicleStatusById(int vehicleStatusId);
    public List<VehicleStatus> getVehicleStatusList();

    //notes: EXECUTE methods
    public int insertVehicleStatus(VehicleStatus vehicleStatus);
    public boolean updateVehicleStatus(VehicleStatus vehicleStatus);
    public boolean deleteVehicleStatus(int vehicleStatusId);
}
