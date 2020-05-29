package com.uqac.stablemanager.member.action;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.model.RoleModel;
import com.uqac.stablemanager.member.service.MemberService;
import com.uqac.stablemanager.member.service.RoleService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import com.uqac.stablemanager.utils.MySQLConnection;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MemberListAction extends AuthenticatedAction {
    private RoleModel defaultRole = new RoleModel("Tous les rôles");
    private List<RoleModel> roles;
    private String selectedRole;

    private List<MemberModel> members;

    @Override
    public String execute() {
        roles = new RoleService(MySQLConnection.getConnection()).list();
        Optional<RoleModel> selectedRoleModel = roles.stream().filter(r -> r.getName().equals(selectedRole)).findFirst();
        if (selectedRoleModel.isPresent() && selectedRoleModel.get() != defaultRole) {
            members = new MemberService(MySQLConnection.getConnection()).list(selectedRoleModel.get());
        } else {
            members = new MemberService(MySQLConnection.getConnection()).list();
        }
        return SUCCESS;
    }

    public List<RoleModel> getRoles() {
        return Stream.concat(Stream.of(defaultRole), roles.stream())
                .collect(Collectors.toList());
    }

    public String getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(String selectedRole) {
        if (!selectedRole.equals(defaultRole.getName()))
            this.selectedRole = selectedRole;
    }

    public List<MemberModel> getMembers() {
        return members;
    }

    public void setMembers(List<MemberModel> members) {
        this.members = members;
    }
}
