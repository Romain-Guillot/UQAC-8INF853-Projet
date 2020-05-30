package com.uqac.stablemanager.security.action;

import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.security.service.RoleService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import com.uqac.stablemanager.utils.MySQLConnection;

import java.util.List;

public class RoleListViewAction extends AuthenticatedAction {
    private List<RoleModel> roles;

    @Override
    public String execute() throws Exception {
        roles = new RoleService(MySQLConnection.getConnection()).list();
        return SUCCESS;
    }

    public List<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleModel> roles) {
        this.roles = roles;
    }
}
