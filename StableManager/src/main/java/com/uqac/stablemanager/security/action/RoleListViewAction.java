package com.uqac.stablemanager.security.action;

import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.security.service.RoleService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public class RoleListViewAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired RoleService roleService;

    private List<RoleModel> roles;

    @Override
    @PreAuthorize("hasAuthority('MANAGE_ROLES')")
    public String execute() {
        roles = roleService.list();
        return SUCCESS;
    }

    public List<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleModel> roles) {
        this.roles = roles;
    }
}
