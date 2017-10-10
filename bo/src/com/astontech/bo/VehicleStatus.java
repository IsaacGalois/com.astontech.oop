package com.astontech.bo;

import java.util.Date;

public class VehicleStatus extends BaseBO {
    private int VehicleStatusId;
    private int VehicleId;
    private EntityType VehicleType;
    private String Notes;
    private Date CreateDate;

    public VehicleStatus() {
        this.VehicleType = new EntityType();
    }
    public VehicleStatus(int VehicleId) {
        this.VehicleType = new EntityType();
        this.VehicleId = VehicleId;
    }

    public int getVehicleStatusId() {
        return VehicleStatusId;
    }

    public void setVehicleStatusId(int vehicleStatusId) {
        VehicleStatusId = vehicleStatusId;
    }

    public int getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(int vehicleId) {
        VehicleId = vehicleId;
    }

    public EntityType getVehicleType() {
        return this.VehicleType;
    }

    public void setVehicleType(EntityType vehicleType) {
        this.VehicleType = vehicleType;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
