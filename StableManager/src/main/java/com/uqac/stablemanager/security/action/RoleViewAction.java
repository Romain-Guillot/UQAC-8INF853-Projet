package com.uqac.stablemanager.security.action;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.IMemberService;
import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.security.service.IRoleService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public class RoleViewAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired IRoleService roleService;
    @Autowired IMemberService mySQLMemberService;

    private String roleName;
    private RoleModel role;
    private List<MemberModel> usersWithThisRole;

    @Override
    @PreAuthorize("hasAuthority('MANAGE_ROLES')")
    public String execute() throws Exception {
        role = roleService.findByName(roleName);
        if (role != null) {
            usersWithThisRole = mySQLMemberService.list(role);
        }
        return SUCCESS;
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
