package com.uqac.stablemanager.security.service;

import com.uqac.stablemanager.security.model.PermissionModel;
import com.uqac.stablemanager.security.model.RoleModel;
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

    public boolean delete(String name) {
        try {
            Map<String, Object> condition = new HashMap<>();
            condition.put("name", name);
            return new DatabaseHelper<>(connection, this::buildRoleFromResultSet).delete("Role", condition);
        } catch (SQLException exception) {
            System.err.println(exception);
            return false;
        }
    }

    public boolean update(RoleModel role) {
        return false;
    }

    public boolean create(RoleModel role) {
        return false;
    }

    private RoleModel buildRoleFromResultSet(ResultSet result) {
        RoleModel role = new RoleModel();
        try {
            role.setName(result.getString("name"));
            List<PermissionModel> permissions = new PermissionService(connection).listByRole(role);
            role.setRights(permissions);
        } catch (SQLException exception) {
            System.err.println(exception);
        }
        return role;
    }
}
