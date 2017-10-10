package com.astontech.bo;

import java.util.Date;

public class Vehicle extends BaseBO implements Comparable{
    private int VehicleId;
    private int Year;
    private String LicensePlate;
    private String Vin;
    private String Color;
    private int isPurchase;
    private int PurchasePrice;
    private Date PurchaseDate;
    private VehicleModel VehicleModel;

    //Constructors
    public Vehicle() {
        this.VehicleModel = new VehicleModel();}
    public Vehicle(String LicensePlate) {
        this.VehicleModel = new VehicleModel();
        this.LicensePlate = LicensePlate;
    }
    public Vehicle(int aYear, VehicleModel aModel) {
        this.Year = aYear;
        this.setVehicleModel(aModel);
    }
    public Vehicle(int aYear, String licensePlate, String vin, String color, VehicleModel vehicleModel) {
        this.Year = aYear;
        this.LicensePlate = licensePlate;
        this.Vin = vin;
        this.Color = color;
        this.VehicleModel = vehicleModel;
    }

    //Getters and Setters
    public int getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(int vehicleId) {
        VehicleId = vehicleId;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getLicensePlate() {
        return LicensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        LicensePlate = licensePlate;
    }

    public String getVin() {
        return Vin;
    }

    public void setVin(String vin) {
        Vin = vin;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int isPurchase() {
        return isPurchase;
    }

    public void setPurchase(int purchase) {
        isPurchase = purchase;
    }

    public int getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        PurchasePrice = purchasePrice;
    }

    public Date getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        PurchaseDate = purchaseDate;
    }

    public VehicleModel getVehicleModel() {
        return this.VehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.VehicleModel = vehicleModel;
    }

    //Helper Functions
    public String GetPurchaseDetails() {
        return "Price: "+this.PurchasePrice+" Date:"+this.PurchaseDate+" Paid-Off?: "+this.isPurchase;
    }

    @Override
    public String toString() {
        return VehicleId+" "+Year+" "+LicensePlate+" "+Vin+" "+Color+" "+this.VehicleModel.getVehicleModelName();
    }

    @Override
    public int compareTo(Object other) {
        Vehicle otherVehicle = (Vehicle) other;
        int retVal;
        if(this.Year > otherVehicle.getYear())
            retVal = 1;
        else if(this.Year < otherVehicle.getYear())
            retVal = -1;
        else
            retVal = 0;
        return retVal;
    }


}
