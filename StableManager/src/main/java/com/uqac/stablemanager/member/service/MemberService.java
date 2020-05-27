package com.uqac.stablemanager.member.service;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.utils.CommonDao;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MemberService extends CommonDao<MemberModel> {

    private final static String TABLE = "Member";

    public MemberService(Connection connection) {
        super(connection);
    }

    public MemberModel findById(String id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ? WHERE id = ?");
            statement.setString(1, TABLE);
            statement.setString(2, id);
            statement.execute();
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        throw new NotImplementedException();
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
