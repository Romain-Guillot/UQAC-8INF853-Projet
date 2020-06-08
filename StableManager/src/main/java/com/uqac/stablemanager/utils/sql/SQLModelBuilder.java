package com.uqac.stablemanager.utils.sql;

import java.sql.ResultSet;

public abstract class SQLModelBuilder<T> {

    protected T model;

    public void reset() {
        model = null;
    }

    public T getModel() {
        return model;
    }

    public abstract void fromResultSet(ResultSet resultSet) throws Exception;
}
