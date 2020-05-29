package com.uqac.stablemanager.member.action;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.model.RoleModel;
import com.uqac.stablemanager.member.service.MemberService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import com.uqac.stablemanager.utils.MySQLConnection;

import java.util.ArrayList;
import java.util.List;

public class MemberListAction extends AuthenticatedAction {

    private List<RoleModel> roles;
    private RoleModel selectedRole;

    private List<MemberModel> members;

    @Override
    public String execute() throws Exception {
        roles = new ArrayList<>();
        roles.add(new RoleModel("Secretaire"));
        roles.add(new RoleModel("Palfrenier"));

        members = new MemberService(MySQLConnection.getConnection()).list();
        return SUCCESS;
    }

    public List<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleModel> roles) {
        this.roles = roles;
    }

    public RoleModel getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(RoleModel selectedRole) {
        this.selectedRole = selectedRole;
    }

    public List<MemberModel> getMembers() {
        return members;
    }

    public void setMembers(List<MemberModel> members) {
        this.members = members;
    }
}
