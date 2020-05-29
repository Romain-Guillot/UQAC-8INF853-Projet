package com.uqac.stablemanager.member.service;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.utils.CommonDao;
import com.uqac.stablemanager.utils.PasswordManager;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.*;
import java.util.Calendar;
import java.util.List;

public class MemberService extends CommonDao<MemberModel> {
    private final static String TABLE = "Member";

    public MemberService(Connection connection) {
        super(connection);
    }

    public MemberModel findById(int id) {
        MemberModel member = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ProfileMember WHERE id = ?");
            statement.setInt(1, id);
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
        member.setId(result.getInt("id"));
        member.setEmail(result.getString("email"));
        member.setFirstName(result.getString("first_name"));
        member.setLastName(result.getString("last_name"));
        member.setBirthDate(result.getDate("birth_date"));
        member.setRegisterAt(result.getDate("register_at"));
        member.setPassword(result.getString("passwd"));
        member.setPostalAddress(result.getString("postal_address"));
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

    public boolean update(MemberModel member) {
        boolean success = false;
        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE ProfileMember SET " +
                    "first_name=?," +
                    "last_name=?," +
                    "email=?," +
                    "birth_date=?," +
                    "postal_address=? " +
                    "WHERE id = ?");
            statement.setString(1, member.getFirstName());
            statement.setString(2, member.getLastName());
            statement.setString(3, member.getEmail());
            statement.setDate(4, new java.sql.Date(member.getBirthDate().getTime()));
            statement.setString(5, member.getPostalAddress());
            statement.setInt(6, member.getId());
            int res = statement.executeUpdate();
            success = res == 1;
            statement.close();
        }catch (SQLException exception) {
            System.err.println(exception);
        }
        return success;
    }

    public boolean changePassword(int memberID, String newPassword) {
        boolean success = false;
        try{
            String hashPassword = PasswordManager.hash(newPassword);
            PreparedStatement statement = connection.prepareStatement("UPDATE ProfileMember SET " +
                    "passwd=?" +
                    "WHERE id = ?");
            statement.setString(1, hashPassword);
            statement.setInt(2, memberID);
            int res = statement.executeUpdate();
            success = res == 1;
            statement.close();
        }catch (SQLException exception) {
            System.err.println(exception);
        }
        return success;
    }

    public boolean delete(int id) {
        boolean success = false;
        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM ProfileMember " +
                    "WHERE id = ?");
            statement.setInt(1, id);
            int res = statement.executeUpdate();
            success = res == 1;
            statement.close();
        }catch (SQLException exception) {
            System.err.println(exception);
        }
        return success;
    }

    public boolean create(MemberModel member) {
        boolean success = false;
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO ProfileMember" +
                    "(first_name, last_name, email, postal_address, birth_date, register_at, passwd)" +
                    "VALUES(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, member.getFirstName());
            statement.setString(2, member.getLastName());
            statement.setString(3, member.getEmail());
            statement.setString(4, member.getPostalAddress());
            if (member.getBirthDate() != null) {
                statement.setDate(5, new java.sql.Date(member.getBirthDate().getTime()));
            } else {
                statement.setDate(5, null);
            }
            long now = Calendar.getInstance().getTime().getTime();
            statement.setDate(6, new java.sql.Date(now));
            statement.setString(7, member.getPostalAddress());
            int res = statement.executeUpdate();
            if (res == 1) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        member.setId(generatedKeys.getInt(1));
                        success = true;
                    }
                }
            }
            statement.close();
        }catch (SQLException exception) {
            System.err.println(exception);
        }
        return success;
    }

    public List<MemberModel> list() {
        throw new NotImplementedException();
    }
}
