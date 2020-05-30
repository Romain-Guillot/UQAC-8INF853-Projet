package com.uqac.stablemanager.utils;

import com.uqac.stablemanager.member.model.MemberModel;

import java.sql.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        buildStatementWithConditionValues(statement, condition.values());
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            model = modelBuilder.apply(result);
        }
        statement.close();
        return model;
    }

    private List<T> list(PreparedStatement statement) throws SQLException {
        List<T> models = new ArrayList<>();
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            models.add(modelBuilder.apply(result));
        }
        return models;
    }

    public List<T> list(String table) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        return list(statement);
    }

    public List<T> list(String table, Map<String, Object> condition) throws SQLException {
        String whereClause = buildWhereClause(condition.keySet());
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table + " WHERE " + whereClause,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        buildStatementWithConditionValues(statement, condition.values());
        return list(statement);
    }

    public boolean delete(String table, Map<String, Object> condition) throws SQLException {
        String whereClause = buildWhereClause(condition.keySet());
        PreparedStatement statement = connection.prepareStatement("DELETE FROM " + table + " WHERE " + whereClause);
        buildStatementWithConditionValues(statement, condition.values());
        int res = statement.executeUpdate();
        statement.close();
        return res == 1;
    }

    public boolean update(String table, Map<String, Object> primaryKey, Map<String, Object> values) throws SQLException {
        String setClause = buildWhereClause(values.keySet());
        String whereClause = buildWhereClause(primaryKey.keySet());
        String query = "UPDATE " + table + " SET " +
                setClause +
                " WHERE " + whereClause;
        PreparedStatement statement = connection.prepareStatement(query);
        Collection<Object> statementValues = Stream.concat(values.values().stream(), primaryKey.values().stream())
                .collect(Collectors.toList());
        buildStatementWithConditionValues(statement, statementValues);
        int res = statement.executeUpdate();
        statement.close();
        return res == 1;
    }

    public Object create(String table, Map<String, Object> values)  throws SQLException {
        Object key = null;
        String columnNames = String.join(",", values.keySet());
        String tokens = String.join(",", Collections.nCopies(values.size(), "?"));
        PreparedStatement statement = connection.prepareStatement("INSERT INTO " + table +
                "(" + columnNames + ") " +
                "VALUES(" + tokens + ")", Statement.RETURN_GENERATED_KEYS);
        buildStatementWithConditionValues(statement, values.values());
        int res = statement.executeUpdate();
        if (res == 1) {
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    key = generatedKeys.getObject(1);
                }
            }
        }
        statement.close();
        return key;
    }



    private void buildStatementWithConditionValues(PreparedStatement statement, Collection<Object> conditionValues) throws SQLException {
        int index = 1;
        for (Object whereValue : conditionValues) {
            statement.setObject(index++, whereValue);
        }
    }

    private String buildWhereClause(Set<String> columns) {
        List<String> whereConditions = new ArrayList<>();
        for (String col : columns) {
            whereConditions.add(col + " = ?");
        }
        return String.join(",", whereConditions);
    }
}
