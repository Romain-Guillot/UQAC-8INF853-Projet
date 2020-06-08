package com.uqac.stablemanager.security.service;

import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.utils.CommonDao;
import com.uqac.stablemanager.utils.sql.NewSQLTableHelper;
import com.uqac.stablemanager.utils.sql.SQLModelBuilder;
import com.uqac.stablemanager.utils.sql.SQLModelDestructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Map;


public class SQLRoleService extends CommonDao<RoleModel> implements IRoleService {
    @Autowired PermissionService permissionService;
    @Autowired SQLModelBuilder<RoleModel> roleBuilder;
    @Autowired SQLModelDestructor<RoleModel> roleDestructor;

    @Override
    public List<RoleModel> list() throws Exception {
        return getSQLHelper().list();
    }

    @Override
    public RoleModel findByName(String name) throws Exception {
        Map<String, Object> condition = Collections.singletonMap("name", name);
        return getSQLHelper().findBy(condition);
    }

    @Override
    public void delete(String name) throws Exception {
        Map<String, Object> condition = Collections.singletonMap("name", name);
        getSQLHelper().delete(condition);
    }

    @Override
    public void update(String roleName, RoleModel role) throws Exception {
        Map<String, Object> primaryKey = Collections.singletonMap("name", roleName);
        permissionService.updateRolePermissions(role);
        getSQLHelper().update(primaryKey, role);
    }

    @Override
    public void create(RoleModel role) throws Exception {
        getSQLHelper().create(role);
        permissionService.updateRolePermissions(role);
    }

    private NewSQLTableHelper<RoleModel> getSQLHelper() {
        return new NewSQLTableHelper<>(connection, "Role", roleBuilder, roleDestructor);
    }
}
