package com.uqac.stablemanager.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MySQLConnection {

    private static Connection connection;

    private MySQLConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Properties props = ApplicationProperties.getProperties();
            connection = DriverManager.getConnection(props.getProperty("mysql.url") + "?"
                    + "user=" + props.getProperty("mysql.user")
                    + "&password=" + props.getProperty("mysql.password")
                    + "&useSSL=" + props.getProperty("mysql.useSSL")
                    + "&serverTimezone=" +props.getProperty("mysql.timezone"));
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
