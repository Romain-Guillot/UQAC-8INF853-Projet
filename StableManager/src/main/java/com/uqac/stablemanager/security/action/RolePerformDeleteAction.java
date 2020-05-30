package com.uqac.stablemanager.security.action;

import com.uqac.stablemanager.security.service.RoleService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import com.uqac.stablemanager.utils.MySQLConnection;

public class RolePerformDeleteAction extends AuthenticatedAction {
    private String roleName;

    @Override
    public String execute() {
        boolean success = new RoleService(MySQLConnection.getConnection()).delete(roleName);
        return success ? SUCCESS : ERROR;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
