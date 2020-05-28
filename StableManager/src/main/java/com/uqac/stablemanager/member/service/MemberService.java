package com.uqac.stablemanager.member.service;

import com.uqac.stablemanager.member.model.AdminModel;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.utils.CommonDao;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MemberService extends CommonDao<MemberModel> {
    private final static String TABLE = "Member";

    public MemberService(Connection connection) {
        super(connection);
    }

    public MemberModel findById(String id) {
        MemberModel member = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ProfileMember WHERE id = ?");
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                member = buildMemberFromResultSet(result);
            }
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return member;

    }

    private MemberModel buildMemberFromResultSet(ResultSet result) throws SQLException {
        MemberModel member = new MemberModel();
        member.setId(result.getString("id"));
        member.setEmail(result.getString("email"));
        member.setFirstName(result.getString("first_name"));
        member.setLastName(result.getString("last_name"));
        member.setBirthDate(result.getDate("birth_date"));
        member.setRegisterAt(result.getDate("register_at"));
//        boolean isAdmin = result.getBoolean("isAdmin");
//        if (isAdmin) {
//            member = new AdminModel(member);
//        }
        return member;
    }

    public MemberModel findByEmail(String email) {
        MemberModel member = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ProfileMember WHERE email = ?");
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                member = buildMemberFromResultSet(result);
            }
        } catch (SQLException exception) {
            System.err.println(exception);
        }
        return member;
    }

    public boolean update(String id) {
        throw new NotImplementedException();
    }

    public boolean delete(String id) {
        throw new NotImplementedException();
    }

    public List<MemberModel> list() {
        throw new NotImplementedException();
    }
}
