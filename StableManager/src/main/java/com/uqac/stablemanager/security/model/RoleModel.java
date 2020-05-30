package com.uqac.stablemanager.security.model;

import com.uqac.stablemanager.security.model.PermissionModel;

import java.io.Serializable;
import java.util.List;

public class RoleModel implements Serializable {
    private String name;
    private String description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
