package com.uqac.stablemanager.homepage;

import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.security.service.RoleService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import com.uqac.stablemanager.utils.MySQLConnection;
import org.apache.struts2.ServletActionContext;

import java.util.List;

public class HomePageAction extends AuthenticatedAction {
    private List<RoleModel> roles;

    @Override
    public String execute() {


        roles = new RoleService(MySQLConnection.getConnection()).list();
        return SUCCESS;
    }

    public List<RoleModel> getRoles() {
        return roles;
    }
}
