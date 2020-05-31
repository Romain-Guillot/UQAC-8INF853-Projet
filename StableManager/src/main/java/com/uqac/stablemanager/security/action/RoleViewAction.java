package com.uqac.stablemanager.security.action;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.MemberService;
import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.security.service.RoleService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleViewAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired RoleService roleService;
    @Autowired MemberService memberService;

    private String roleName;
    private RoleModel role;
    private List<MemberModel> usersWithThisRole;

    @Override
    public String execute() {
        role = roleService.findByName(roleName);
        usersWithThisRole = memberService.list(role);
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
