package com.uqac.stablemanager.security.service;

import com.uqac.stablemanager.security.model.PermissionModel;
import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.utils.CommonDao;
import com.uqac.stablemanager.utils.SQLTableOperationsHelper;

import java.sql.*;
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

    public boolean updateRolePermissions(RoleModel role) {
        try {
            PreparedStatement st = connection.prepareStatement("insert ignore into RolePermissionAssoc values(?,?)" );
            connection.setAutoCommit(false);
            for (PermissionModel permission : role.getRights()) {
                st.setString(1, role.getName());
                st.setString(2, permission.getName());
                st.executeUpdate();
            }
            connection.commit();
            st.close();
            connection.setAutoCommit(true);
            return true;
        } catch (SQLException exception) {
            System.out.println(exception);
            try {connection.setAutoCommit(true); connection.rollback();} catch (SQLException e) { }
            return false;
        }
    }

    public List<PermissionModel> list() {
        try {
            return new SQLTableOperationsHelper<>(connection, this::buildPermissionFromResultSet).list("Permission");
        } catch (SQLException exception) {
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
