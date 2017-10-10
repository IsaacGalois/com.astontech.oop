package com.astontech.dao;

import com.astontech.bo.VehicleModel;

import java.util.List;

public interface VehicleModelDAO {

    //notes: GET methods
    public VehicleModel getVehicleModelById(int vehicleModelId);
    public List<VehicleModel> getVehicleModelList();

    //notes: EXECUTE methods
    public int insertVehicleModel(VehicleModel vehicleModel);
    public boolean updateVehicleModel(VehicleModel vehicleModel);
    public boolean deleteVehicleModel(int vehicleModelId);
    
}
