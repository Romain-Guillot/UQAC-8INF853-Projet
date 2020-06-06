package com.uqac.stablemanager.security.service;

import com.uqac.stablemanager.security.model.PermissionModel;
import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.utils.CommonDao;
import com.uqac.stablemanager.utils.sql.SQLTableOperationsHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public class RoleService extends CommonDao<RoleModel> {

    @Autowired PermissionService permissionService;
    private final SQLTableOperationsHelper<RoleModel> tableOperationsHelper;

    public RoleService() {
        tableOperationsHelper = new SQLTableOperationsHelper<>(connection, "Role", this::buildRoleFromResultSet, this::modelDestructor);
    }

    public List<RoleModel> list() {
        try {
            return tableOperationsHelper.list();
        } catch (SQLException exception) {
            log(Level.SEVERE, null, exception);
            return null;
        }
    }

    public RoleModel findByName(String name) {
        try {
            Map<String, Object> condition = Collections.singletonMap("name", name);
            return tableOperationsHelper.findBy(condition);
        } catch (SQLException exception) {
            log(Level.SEVERE, null, exception);
            return null;
        }
    }

    public boolean delete(String name) {
        try {
            Map<String, Object> condition = Collections.singletonMap("name", name);
            return tableOperationsHelper.delete(condition);
        } catch (SQLException exception) {
            log(Level.SEVERE, null, exception);
            return false;
        }
    }

    public boolean update(String roleName, RoleModel role) {
        try {
            Map<String, Object> primaryKey = Collections.singletonMap("name", roleName);
            boolean success = permissionService.updateRolePermissions(role);
            success = success && tableOperationsHelper.update(primaryKey, role);
            return success;
        } catch (SQLException exception) {
            log(Level.SEVERE, null, exception);
            return false;
        }
    }

    public boolean create(RoleModel role) {
        try {
            tableOperationsHelper.create(role);
            permissionService.updateRolePermissions(role);
            return true;
        } catch (SQLException exception) {
            log(Level.SEVERE, null, exception);
            return false;
        }
    }

    private Map<String, Object> modelDestructor(RoleModel roleModel) {
        Map<String, Object> values = new HashMap<>();
        values.put("name", roleModel.getName());
        values.put("description", roleModel.getDescription());
        return values;
    }

    private RoleModel buildRoleFromResultSet(ResultSet result) {
        RoleModel role = new RoleModel();
        try {
            role.setName(result.getString("name"));
            role.setDescription(result.getString("description"));
            List<PermissionModel> permissions = permissionService.listByRole(role);
            role.setRights(permissions);
        } catch (SQLException exception) {
            log(Level.SEVERE, null, exception);
        }
        return role;
    }
}
