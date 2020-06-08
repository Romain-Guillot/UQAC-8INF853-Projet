package com.uqac.stablemanager.security.action;

import com.uqac.stablemanager.security.service.IRoleService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

public class RolePerformDeleteAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired IRoleService roleService;

    private String roleName;

    @Override
    @PreAuthorize("hasAuthority('MANAGE_ROLES')")
    public String execute() throws Exception {
        roleService.delete(roleName);
        return SUCCESS;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
