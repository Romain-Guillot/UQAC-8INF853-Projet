package com.uqac.stablemanager.security.action;

import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.security.service.RoleService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import com.uqac.stablemanager.utils.MySQLConnection;

public class RoleViewAction extends AuthenticatedAction {

    private String roleName;
    private RoleModel role;

    @Override
    public String execute() {
        role = new RoleService(MySQLConnection.getConnection()).findByName(roleName);
        return SUCCESS;
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
}
