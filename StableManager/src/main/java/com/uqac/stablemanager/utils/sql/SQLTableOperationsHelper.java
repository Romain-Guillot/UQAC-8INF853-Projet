package com.uqac.stablemanager.utils.sql;

import java.sql.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SQLTableOperationsHelper<T> {
    private final Connection connection;
    private final Function<ResultSet, T> modelBuilder;
    private final Function<T, Map<String, Object>> modelDestructor;
    private final String tableName;

    public SQLTableOperationsHelper(Connection connection, String tableName, Function<ResultSet, T> modelBuilder, Function<T, Map<String, Object>> modelDestructor) {
        this.connection = connection;
        this.modelBuilder = modelBuilder;
        this.modelDestructor = modelDestructor;
        this.tableName = tableName;
    }

    public T findBy(Map<String, Object> condition) throws SQLException {
        T model = null;
        String whereClause = buildWhereClause(condition.keySet());
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + tableName + " WHERE " + whereClause);
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

    public List<T> list() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + tableName,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        return list(statement);
    }

    public List<T> list(Map<String, Object> condition) throws SQLException {
        String whereClause = buildWhereClause(condition.keySet());
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + tableName + " WHERE " + whereClause,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        buildStatementWithConditionValues(statement, condition.values());
        return list(statement);
    }

    public boolean delete(Map<String, Object> condition) throws SQLException {
        String whereClause = buildWhereClause(condition.keySet());
        PreparedStatement statement = connection.prepareStatement("DELETE FROM " + tableName + " WHERE " + whereClause);
        buildStatementWithConditionValues(statement, condition.values());
        int res = statement.executeUpdate();
        statement.close();
        return res == 1;
    }

    public boolean update(Map<String, Object> primaryKey, T model) throws SQLException {
        Map<String, Object> values = modelDestructor.apply(model);
        String setClause = buildWhereClause(values.keySet());
        String whereClause = buildWhereClause(primaryKey.keySet());
        String query = "UPDATE " + tableName + " SET " +
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

    public Object create(T model)  throws SQLException {
        Map<String, Object> values = modelDestructor.apply(model);
        Object key = null;
        String columnNames = String.join(",", values.keySet());
        String tokens = String.join(",", Collections.nCopies(values.size(), "?"));
        PreparedStatement statement = connection.prepareStatement("INSERT INTO " + tableName +
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
