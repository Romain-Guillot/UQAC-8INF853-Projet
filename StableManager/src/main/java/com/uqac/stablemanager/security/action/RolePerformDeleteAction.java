package com.uqac.stablemanager.security.action;

import com.uqac.stablemanager.security.service.RoleService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

public class RolePerformDeleteAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired RoleService roleService;

    private String roleName;

    @Override
    @PreAuthorize("hasAuthority('MANAGE_ROLES')")
    public String execute() {
        boolean success = roleService.delete(roleName);
        return success ? SUCCESS : ERROR;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
