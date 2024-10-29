package com.bptn.attendance.system.attendance_system.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSql {


    private static final String URL = "jdbc:postgresql://localhost:5432/attendance_sheet";
    private static final String USER = "postgres";
    private static final String PASSWORD = "pg123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
