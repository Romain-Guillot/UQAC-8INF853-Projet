package com.uqac.stablemanager.member.service;

import com.uqac.stablemanager.member.model.RoleModel;
import com.uqac.stablemanager.utils.CommonDao;
import com.uqac.stablemanager.utils.DatabaseHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleService extends CommonDao<RoleModel> {

    public RoleService(Connection connection) {
        super(connection);
    }

    public List<RoleModel> list() {
        try {
            return new DatabaseHelper<>(connection, this::buildRoleFromResultSet).list("Role");
        } catch (SQLException exception) {
            System.err.println(exception);
            return null;
        }
    }

    public RoleModel findByName(String name) {
        try {
            Map<String, Object> condition = new HashMap<>();
            condition.put("name", name);
            return new DatabaseHelper<>(connection, this::buildRoleFromResultSet).findBy("Role", condition);
        } catch (SQLException exception) {
            System.err.println(exception);
            return null;
        }
    }

    public RoleModel buildRoleFromResultSet(ResultSet result) {
        RoleModel role = new RoleModel();
        try {
            role.setName(result.getString("name"));
        } catch (SQLException exception) {
            System.err.println(exception);
        }
        return role;
    }
}
