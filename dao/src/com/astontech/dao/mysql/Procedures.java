package com.astontech.dao.mysql;

public class Procedures {

//    final static String GET_Address = "{call usp_GetAddress(?,?)}";
//    final static String EXEC_Address = ;

    final static String GET_Employee = "{call usp_GetEmployee(?,?)}";
    final static String EXEC_Employee = "{call usp_ExecuteEmployee(?, ?, ?, ?, ?, ?, ?)}";

    final static String GET_Phone = "{call usp_GetPhone(?,?)}";
    final static String EXEC_Phone = "{call usp_ExecutePhone(?, ?, ?, ?, ?, ?, ?, ?)}";

    final static String GET_Email = "{call usp_GetEmail(?,?)}";
    final static String EXEC_Email = "{call usp_ExecuteEmail(?, ?, ?, ?, ?)}";

    final static String GET_Vehicle = "{call usp_GetVehicle(?,?)}";
    final static String EXEC_Vehicle = "{call usp_ExecuteVehicle(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

    final static String GET_VehicleMake = "{call usp_GetVehicleMake(?,?)}";
    final static String EXEC_VehicleMake = "{call usp_ExecuteVehicleMake(?, ?, ?, ?)}";

    final static String GET_VehicleModel = "{call usp_GetVehicleModel(?,?)}";
    final static String EXEC_VehicleModel = "{call usp_ExecuteVehicleModel(?, ?, ?, ?)}";
}
