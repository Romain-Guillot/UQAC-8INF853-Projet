package com.uqac.stablemanager.member.service;

import com.uqac.stablemanager.member.model.RoleModel;
import com.uqac.stablemanager.utils.CommonDao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class RoleService extends CommonDao<RoleModel> {

    public RoleService(Connection connection) {
        super(connection);
    }

    public List<RoleModel> list() {
        List<RoleModel> roles = new ArrayList<>();
        roles.add(new RoleModel("Secretaire"));
        roles.add(new RoleModel("Palfrenier"));
        return roles;
    }
}
