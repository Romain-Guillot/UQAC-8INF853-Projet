package com.uqac.stablemanager.security.model;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

public class PermissionModel implements GrantedAuthority, Serializable {
    private String name;
    private String description;

    public PermissionModel() { }

    @Override
    public String getAuthority() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
