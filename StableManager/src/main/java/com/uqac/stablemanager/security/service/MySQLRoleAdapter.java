package com.uqac.stablemanager.security.service;

import com.uqac.stablemanager.security.model.RoleModel;

import java.sql.ResultSet;

public class MySQLRoleAdapter extends RoleModel {

    public MySQLRoleAdapter(ResultSet resultSet) throws Exception {
        setName(resultSet.getString("name"));
        setDescription(resultSet.getString("description"));
        setRights(null);
    }
}
