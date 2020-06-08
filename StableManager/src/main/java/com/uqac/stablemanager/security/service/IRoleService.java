package com.uqac.stablemanager.security.service;

import com.uqac.stablemanager.security.model.RoleModel;

import java.util.List;

public interface IRoleService {

    List<RoleModel> list() throws Exception;

    RoleModel findByName(String name) throws Exception;

    void delete(String name) throws Exception;

    void update(String roleName, RoleModel role) throws Exception;

    void create(RoleModel role) throws Exception;
}
