package com.uqac.stablemanager.security.action;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.MemberService;
import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.security.service.RoleService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import com.uqac.stablemanager.utils.MySQLConnection;

import java.util.List;

public class RoleViewAction extends AuthenticatedAction {

    private String roleName;
    private RoleModel role;
    private List<MemberModel> usersWithThisRole;

    @Override
    public String execute() {
        role = new RoleService(MySQLConnection.getConnection()).findByName(roleName);
        usersWithThisRole = new MemberService(MySQLConnection.getConnection()).list(role);
        return role != null ? SUCCESS : ERROR;
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

    public List<MemberModel> getUsersWithThisRole() {
        return usersWithThisRole;
    }
}
