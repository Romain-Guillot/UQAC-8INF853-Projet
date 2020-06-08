package com.uqac.stablemanager.security.service;

import com.uqac.stablemanager.security.model.PermissionModel;
import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.utils.sql.SQLModelBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.util.List;

public class SQLRoleBuilder extends SQLModelBuilder<RoleModel> {
    @Autowired PermissionService permissionService;

    @Override
    public void fromResultSet(ResultSet resultSet) throws Exception {
        model = new RoleModel();
        model.setName(resultSet.getString("name"));
        model.setDescription(resultSet.getString("description"));
        List<PermissionModel> permissions = permissionService.listByRole(model);
        model.setRights(permissions);
    }
}
