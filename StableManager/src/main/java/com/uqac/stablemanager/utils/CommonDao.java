package com.uqac.stablemanager.utils;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;

public class CommonDao<T> {
    @Autowired
    protected Connection connection;
}
