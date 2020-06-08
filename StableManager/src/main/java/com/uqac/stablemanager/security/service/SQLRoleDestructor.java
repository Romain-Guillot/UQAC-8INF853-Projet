package com.uqac.stablemanager.security.service;

import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.utils.sql.SQLModelDestructor;

import java.util.HashMap;
import java.util.Map;

public class SQLRoleDestructor implements SQLModelDestructor<RoleModel> {
    @Override
    public Map<String, Object> destruct(RoleModel model) {
        Map<String, Object> values = new HashMap<>();
        values.put("name", model.getName());
        values.put("description", model.getDescription());
        return values;
    }
}
