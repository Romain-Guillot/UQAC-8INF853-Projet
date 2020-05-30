package com.uqac.stablemanager.security.action;

import com.uqac.stablemanager.security.model.PermissionModel;
import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.security.service.PermissionService;
import com.uqac.stablemanager.security.service.RoleService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import com.uqac.stablemanager.utils.MySQLConnection;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RoleEditionAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    private RoleModel role;
    private String roleName;
    private List<String> selectedPermissions;

    @Override
    public String execute() {
        Map<String, PermissionModel> allPermissions = getPermissions().stream()
                .collect(Collectors.toMap(PermissionModel::getName, p -> p));
        List<PermissionModel> selectedPermissionModels = selectedPermissions.stream().map(allPermissions::get)
                .collect(Collectors.toList());
        role.setRights(selectedPermissionModels);
        boolean success;
        if (roleName == null) {
            success = new RoleService(MySQLConnection.getConnection()).create(role);
        } else {
            success = new RoleService(MySQLConnection.getConnection()).update(roleName, role);
        }
        return success ? SUCCESS : ERROR;
    }

    @Override
    public String input() throws Exception {
        if (roleName != null)
            role = new RoleService(MySQLConnection.getConnection()).findByName(roleName);
        return INPUT;
    }


    @Override
    public void validate() {
        super.validate();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

    public List<PermissionModel> getPermissions() {
        return new PermissionService(MySQLConnection.getConnection()).list();
    }

    public List<String> getSelectedPermissions() {
        return selectedPermissions;
    }

    public void setSelectedPermissions(List<String> selectedPermissions) {
        this.selectedPermissions = selectedPermissions;
    }
}
