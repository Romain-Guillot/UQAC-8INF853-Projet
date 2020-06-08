package com.uqac.stablemanager.member.action;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.IMemberService;
import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.security.service.IRoleService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

public class MemberListViewAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired IMemberService mySQLMemberService;
    @Autowired IRoleService roleService;

    private List<RoleModel> roles;
    private String selectedRole;
    private List<MemberModel> members;

    @Override
    @PreAuthorize("hasAuthority('READ_ALL_PROFILES')")
    public String execute() throws Exception {
        roles = roleService.list();
        Optional<RoleModel> selectedRoleModel = roles.stream().filter(r -> r.getName().equals(selectedRole)).findFirst();
        if (selectedRoleModel.isPresent()) {
            members = mySQLMemberService.list(selectedRoleModel.get());
        } else {
            members = mySQLMemberService.list();
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
