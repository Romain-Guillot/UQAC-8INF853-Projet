package com.uqac.stablemanager.member.action;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.member.service.MemberService;
import com.uqac.stablemanager.security.service.RoleService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import com.uqac.stablemanager.utils.MySQLConnection;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

@PreAuthorize("hasAuthority('READ_ALL_PROFILES')")
public class MemberListAction extends AuthenticatedAction {
    private List<RoleModel> roles;
    private String selectedRole;

    private List<MemberModel> members;

    @Override
    public String execute() {
        roles = new RoleService(MySQLConnection.getConnection()).list();
        Optional<RoleModel> selectedRoleModel = roles.stream().filter(r -> r.getName().equals(selectedRole)).findFirst();
        if (selectedRoleModel.isPresent()) {
            members = new MemberService(MySQLConnection.getConnection()).list(selectedRoleModel.get());
        } else {
            members = new MemberService(MySQLConnection.getConnection()).list();
        }
        return SUCCESS;
    }

    public List<RoleModel> getRoles() {
        return roles;
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
