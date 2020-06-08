package com.uqac.stablemanager.security.service;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.security.model.PermissionModel;
import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.utils.CommonDao;
import com.uqac.stablemanager.utils.sql.NewSQLTableHelper;
import com.uqac.stablemanager.utils.sql.SQLModelBuilder;
import com.uqac.stablemanager.utils.sql.SQLModelDestructor;
import com.uqac.stablemanager.utils.sql.SQLTableOperationsHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class PermissionService  extends CommonDao<PermissionModel> {
    @Autowired private SQLModelBuilder<PermissionModel> permissionBuilder;
    @Autowired private SQLModelDestructor<PermissionModel> permissionDestructor;

    public List<PermissionModel> listByRole(RoleModel role) throws Exception {
        try {
            List<PermissionModel> permissions = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Permission as P " +
                    "INNER JOIN RolePermissionAssoc as ASSOC on ASSOC.permission_name = P.name " +
                    "WHERE ASSOC.role_name = ?");
            statement.setString(1, role.getName());
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                permissionBuilder.fromResultSet(result);
                permissions.add(permissionBuilder.getModel());
            }
            return permissions;
        } catch (SQLException exception) {
            log(Level.SEVERE, null, exception);
            return null;
        }
    }

    public boolean updateRolePermissions(RoleModel role) {
        try {
            PreparedStatement st1 = connection.prepareStatement("DELETE FROM RolePermissionAssoc WHERE role_name = ? ");
            st1.setString(1, role.getName());
            st1.executeUpdate();
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
            log(Level.SEVERE, null, exception);
            try {connection.setAutoCommit(true); connection.rollback();}
            catch (SQLException e) {log(Level.SEVERE, null, exception); }
            return false;
        }
    }

    public List<PermissionModel> list() throws Exception {
        return getSQLHelper().list();
    }

    private NewSQLTableHelper<PermissionModel> getSQLHelper() {
        return new NewSQLTableHelper<>(connection, "ProfileMember", permissionBuilder, permissionDestructor);
    }

}
