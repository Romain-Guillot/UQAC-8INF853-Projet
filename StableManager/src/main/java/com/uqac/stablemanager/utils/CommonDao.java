package com.uqac.stablemanager.utils;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommonDao<T> {
    @Autowired
    protected Connection connection;

    public void log(Level level, String message, Exception exception) {
        Logger.getLogger(this.getClass().getName()).log(level, message, exception);
    }
}
