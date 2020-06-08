package com.uqac.stablemanager.member.service;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.security.service.IRoleService;
import com.uqac.stablemanager.utils.sql.SQLModelBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;

public class SQLMemberBuilder extends SQLModelBuilder<MemberModel> {
    @Autowired private IRoleService roleService;


    public void fromResultSet(ResultSet resultSet) throws Exception {
        reset();
        model = new MemberModel();
        model.setId(resultSet.getInt("profile_id"));
        model.setEmail(resultSet.getString("email"));
        model.setFirstName(resultSet.getString("first_name"));
        model.setLastName(resultSet.getString("last_name"));
        model.setBirthDate(resultSet.getDate("birth_date"));
        model.setRegisterAt(resultSet.getDate("register_at"));
        model.setPassword(resultSet.getString("passwd"));
        model.setPostalAddress(resultSet.getString("postal_address"));
        model.setRole(roleService.findByName(resultSet.getString("role_name")));
    }
}
