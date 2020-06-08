package com.uqac.stablemanager.security.service;

import com.uqac.stablemanager.security.model.PermissionModel;
import com.uqac.stablemanager.utils.sql.SQLModelDestructor;

import java.util.Map;

public class SQLPermissionDestructor implements SQLModelDestructor<PermissionModel> {
    @Override
    public Map<String, Object> destruct(PermissionModel model) {
        throw new UnsupportedOperationException();
    }
}
