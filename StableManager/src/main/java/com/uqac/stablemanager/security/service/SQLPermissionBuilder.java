package com.uqac.stablemanager.security.service;

import com.uqac.stablemanager.security.model.PermissionModel;
import com.uqac.stablemanager.utils.sql.SQLModelBuilder;

import java.sql.ResultSet;

public class SQLPermissionBuilder extends SQLModelBuilder<PermissionModel> {
    @Override
    public void fromResultSet(ResultSet resultSet) throws Exception {
        model = new PermissionModel();
        model.setName(resultSet.getString("name"));
        model.setDescription(resultSet.getString("description"));
    }
}
