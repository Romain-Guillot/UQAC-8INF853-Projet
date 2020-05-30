package com.uqac.stablemanager.homepage;

import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.security.service.RoleService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 */
public class HomePageAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired
    private RoleService roleService;
    private List<RoleModel> roles;

    @Override
    public String execute() {
        roles = roleService.list();
        return SUCCESS;
    }

    public List<RoleModel> getRoles() {
        return roles;
    }
}
