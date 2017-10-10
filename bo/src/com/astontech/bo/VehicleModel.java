package com.astontech.bo;

public class VehicleModel extends BaseBO {
    private int VehicleModelId;
    private String VehicleModelName;
    private VehicleMake VehicleMake;

    public VehicleModel() {
        this.VehicleMake = new VehicleMake();
    }
    public VehicleModel(String VehicleModelName) {
        this.VehicleMake = new VehicleMake();
        this.VehicleModelName = VehicleModelName;
    }

    public int getVehicleModelId() {
        return VehicleModelId;
    }

    public void setVehicleModelId(int vehicleModelId) {
        VehicleModelId = vehicleModelId;
    }

    public String getVehicleModelName() {
        return VehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        VehicleModelName = vehicleModelName;
    }

    public VehicleMake getVehicleMake() {
        return this.VehicleMake;
    }

    public void setVehicleMake(VehicleMake vehicleMake) {
        this.VehicleMake = vehicleMake;
    }

    public String toString() {
        return this.getVehicleModelId()+" "+this.getVehicleModelName()+" "+this.getVehicleMake().getVehicleMakeName();
    }
}
