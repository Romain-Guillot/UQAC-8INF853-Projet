package com.uqac.stablemanager.security.action;

import com.uqac.stablemanager.security.model.PermissionModel;
import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.security.service.IRoleService;
import com.uqac.stablemanager.security.service.PermissionService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class RoleEditionAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired IRoleService roleService;
    @Autowired PermissionService permissionService;

    private RoleModel role;
    private String roleName;
    private List<String> selectedPermissions;

    @Override
    @PreAuthorize("hasAuthority('MANAGE_ROLES')")
    public String execute() throws Exception {
        Map<String, PermissionModel> allPermissions = getPermissions().stream().collect(Collectors.toMap(PermissionModel::getName, p -> p));
        List<PermissionModel> selectedPermissionModels = selectedPermissions.stream().map(allPermissions::get).collect(Collectors.toList());
        role.setRights(selectedPermissionModels);
        if (roleName == null || roleName.isEmpty()) {
            roleService.create(role);
        } else {
            roleService.update(roleName, role);
        }
        return SUCCESS;
    }

    @Override
    @PreAuthorize("hasAuthority('MANAGE_ROLES')")
    public String input() throws Exception {
        if (roleName != null)
            role = roleService.findByName(roleName);
        return INPUT;
    }


    @Override
    public void validate() {
        super.validate();
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

    public List<PermissionModel> getPermissions() throws Exception {
        return permissionService.list(); // TODO : mettre en variable d'instance
    }

    public List<String> getSelectedPermissions() {
        return selectedPermissions;
    }

    public void setSelectedPermissions(List<String> selectedPermissions) {
        this.selectedPermissions = selectedPermissions;
    }
}
