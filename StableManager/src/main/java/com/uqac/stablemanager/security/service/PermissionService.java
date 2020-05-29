package com.uqac.stablemanager.security.service;

import com.uqac.stablemanager.security.model.PermissionModel;
import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.utils.CommonDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PermissionService  extends CommonDao<PermissionModel> {

    public PermissionService(Connection connection) {
        super(connection);
    }

    public List<PermissionModel> listByRole(RoleModel role) {
        try {
            List<PermissionModel> permissions = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Permission as P " +
                    "INNER JOIN RolePermissionAssoc as ASSOC on ASSOC.permission_name = P.name " +
                    "WHERE ASSOC.role_name = ?");
            statement.setString(1, role.getName());
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                permissions.add(buildPermissionFromResultSet(result));
            }
            return permissions;
        } catch (SQLException exception) {
            System.err.println(exception);
            return null;
        }
    }

    public PermissionModel buildPermissionFromResultSet(ResultSet result) {
        try {
            PermissionModel permission = new PermissionModel();
            permission.setName(result.getString("name"));
            permission.setDescription(result.getString("description"));
            return permission;
        } catch (SQLException exception) {
            System.err.println(exception);
            return null;
        }
    }

}
