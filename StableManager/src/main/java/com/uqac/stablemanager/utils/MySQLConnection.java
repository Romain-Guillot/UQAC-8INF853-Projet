package com.uqac.stablemanager.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {

    private static Connection connection;

    private MySQLConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost/stablemanager?"
                    + "user=root&password=root&useSSL=false&serverTimezone=UTC");
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            new MySQLConnection();
        }
        return connection;
    }
}
