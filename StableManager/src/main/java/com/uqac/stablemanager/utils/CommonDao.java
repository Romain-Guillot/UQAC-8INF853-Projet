package com.uqac.stablemanager.utils;

import java.sql.Connection;

public class CommonDao<T> {
    protected Connection connection;

    public CommonDao(Connection connection){
        this.connection = connection;
    }
}
