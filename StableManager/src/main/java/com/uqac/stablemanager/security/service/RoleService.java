package com.uqac.stablemanager.security.service;

import com.uqac.stablemanager.security.model.PermissionModel;
import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.utils.CommonDao;
import com.uqac.stablemanager.utils.DatabaseHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleService extends CommonDao<RoleModel> {

    private static final String TABLE = "Role";

    public RoleService(Connection connection) {
        super(connection);
    }

    public List<RoleModel> list() {
        try {
            return new DatabaseHelper<>(connection, this::buildRoleFromResultSet).list(TABLE);
        } catch (SQLException exception) {
            System.err.println(exception);
            return null;
        }
    }

    public RoleModel findByName(String name) {
        try {
            Map<String, Object> condition = Collections.singletonMap("name", name);
            return new DatabaseHelper<>(connection, this::buildRoleFromResultSet).findBy(TABLE, condition);
        } catch (SQLException exception) {
            System.err.println(exception);
            return null;
        }
    }

    public boolean delete(String name) {
        try {
            Map<String, Object> condition = Collections.singletonMap("name", name);
            return new DatabaseHelper<>(connection, this::buildRoleFromResultSet).delete(TABLE, condition);
        } catch (SQLException exception) {
            System.err.println(exception);
            return false;
        }
    }

    public boolean update(String roleName, RoleModel role) {
        try {
            Map<String, Object> primaryKey = Collections.singletonMap("name", roleName);
            Map<String, Object> values = new HashMap<String, Object>() {
                {put("name", role.getName());}
                {put("description", role.getDescription());}
            };
            return new DatabaseHelper<>(connection, this::buildRoleFromResultSet).update(TABLE, primaryKey, values);
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public boolean create(RoleModel role) {
        return false;
    }

    private RoleModel buildRoleFromResultSet(ResultSet result) {
        RoleModel role = new RoleModel();
        try {
            role.setName(result.getString("name"));
            role.setDescription(result.getString("description"));
            List<PermissionModel> permissions = new PermissionService(connection).listByRole(role);
            role.setRights(permissions);
        } catch (SQLException exception) {
            System.err.println(exception);
        }
        return role;
    }
}
