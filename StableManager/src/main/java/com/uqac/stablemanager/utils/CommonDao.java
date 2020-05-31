package com.uqac.stablemanager.utils;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommonDao<T> {
    protected Connection connection = MySQLConnection.getConnection();

    public void log(Level level, String message, Exception exception) {
        Logger.getLogger(this.getClass().getName()).log(level, message, exception);
    }
}
