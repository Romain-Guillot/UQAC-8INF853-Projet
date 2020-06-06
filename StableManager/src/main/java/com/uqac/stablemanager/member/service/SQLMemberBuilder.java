package com.uqac.stablemanager.member.service;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.security.service.RoleService;
import com.uqac.stablemanager.utils.sql.SQLModelBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLMemberBuilder implements SQLModelBuilder<MemberModel> {
    @Autowired private RoleService roleService;
    private MemberModel member;

    public void reset() {
        member = null;
    }

    public MemberModel getModel() {
        MemberModel temp = member;
        reset();
        return temp;
    }

    public void fromResultSet(ResultSet resultSet) throws SQLException {
        reset();
        member = new MemberModel();
        member.setId(resultSet.getInt("profile_id"));
        member.setEmail(resultSet.getString("email"));
        member.setFirstName(resultSet.getString("first_name"));
        member.setLastName(resultSet.getString("last_name"));
        member.setBirthDate(resultSet.getDate("birth_date"));
        member.setRegisterAt(resultSet.getDate("register_at"));
        member.setPassword(resultSet.getString("passwd"));
        member.setPostalAddress(resultSet.getString("postal_address"));
        member.setRole(roleService.findByName(resultSet.getString("role_name")));
    }
}
