package com.uqac.stablemanager.member.action;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.model.RoleModel;
import com.uqac.stablemanager.member.service.MemberService;
import com.uqac.stablemanager.member.service.RoleService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import com.uqac.stablemanager.utils.MySQLConnection;

import java.util.List;

public class MemberListAction extends AuthenticatedAction {

    private List<RoleModel> roles;
    private String selectedRole;

    private List<MemberModel> members;

    @Override
    public String execute() {
        roles = new RoleService(MySQLConnection.getConnection()).list();
        members = new MemberService(MySQLConnection.getConnection()).list();
        return SUCCESS;
    }

    public List<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleModel> roles) {
        this.roles = roles;
    }

    public String getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(String selectedRole) {
        this.selectedRole = selectedRole;
    }

    public List<MemberModel> getMembers() {
        return members;
    }

    public void setMembers(List<MemberModel> members) {
        this.members = members;
    }
}
