package com.uqac.stablemanager.utils;

import com.uqac.stablemanager.member.model.MemberModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class DatabaseHelper<T> {
    private final Connection connection;
    private final Function<ResultSet, T> modelBuilder;

    public DatabaseHelper(Connection connection, Function<ResultSet, T> modelBuilder) {
        this.connection = connection;
        this.modelBuilder = modelBuilder;
    }

    public T findBy(String table, Map<String, Object> condition) throws SQLException {
        T model = null;
        String whereClause = buildWhereClause(condition.keySet());
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table + " WHERE " + whereClause);
        int index = 1;
        for (Object whereValue : condition.values()) {
            statement.setObject(index++, whereValue);
        }
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            model = modelBuilder.apply(result);
        }
        statement.close();
        return model;
    }

    public List<T> list(String table) throws SQLException {
        List<T> models = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        models = new ArrayList<>();
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            models.add(modelBuilder.apply(result));
        };
        return models;
    }

    private String buildWhereClause(Set<String> columns) {
        List<String> whereConditions = new ArrayList<>();
        for (String col : columns) {
            whereConditions.add(col + " = ?");
        }
        return String.join(",", whereConditions);
    }
}
