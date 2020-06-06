package com.uqac.stablemanager.member.service;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.security.model.RoleModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLMemberAdapter extends MemberModel {

    public MySQLMemberAdapter(ResultSet resultSet, RoleModel role) throws SQLException {
        setId(resultSet.getInt("profile_id"));
        setEmail(resultSet.getString("email"));
        setFirstName(resultSet.getString("first_name"));
        setLastName(resultSet.getString("last_name"));
        setBirthDate(resultSet.getDate("birth_date"));
        setRegisterAt(resultSet.getDate("register_at"));
        setPassword(resultSet.getString("passwd"));
        setPostalAddress(resultSet.getString("postal_address"));
        setRole(role);
    }
}
