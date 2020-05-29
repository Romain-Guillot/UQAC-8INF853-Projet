package com.uqac.stablemanager.member.model;

import javax.management.relation.Role;
import java.util.List;

public class RoleModel {
    private String name;
    private List<PermissionModel> rights;

    public RoleModel() { }

    public RoleModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PermissionModel> getRights() {
        return rights;
    }

    public void setRights(List<PermissionModel> rights) {
        this.rights = rights;
    }
}
