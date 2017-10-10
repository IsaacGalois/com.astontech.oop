package com.astontech.dao.mysql;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class MySQL {

    protected static String dbHost = "localhost";
    protected static String dbName = "AstonEngineer";
    protected static String dbUser = "consoleUser";
    protected static String dbPass = "qwe123$!";
    protected static String useSSL = "false";
    protected static String procBod = "true";
    protected static Connection connection = null;

    final static Logger logger = Logger.getLogger(MySQL.class);

    protected static final int GET_BY_ID = 10;
    protected static final int GET_COLLECTION = 20;
    protected static final int INSERT = 10;
    protected static final int UPDATE = 20;
    protected static final int DELETE = 30;

    protected static void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("MySQL Driver not found! " + ex);
        }

//        logger.info("MySQL Driver Registered.");


        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":3306/" + dbName + "?useSSL=" + useSSL + "&noAccessToProcedureBodies=" + procBod+"&zeroDateTimeBehavior=convertToNull", dbUser, dbPass);
        } catch (SQLException ex) {
            logger.error("Connection Failed! " + ex);
        }

//        if (connection != null)
//            logger.info("Successfully connected to MySQL database");
//        else
//            logger.info("Connection Failed");
    }

    protected static void Disconnect() {
        try {
            connection.close();
        } catch (java.sql.SQLException ex) {
            logger.error(ex);
        }
    }
}
