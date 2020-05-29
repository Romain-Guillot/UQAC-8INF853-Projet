package com.uqac.stablemanager.member.service;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.model.RoleModel;
import com.uqac.stablemanager.utils.CommonDao;
import com.uqac.stablemanager.utils.DatabaseHelper;
import com.uqac.stablemanager.utils.MySQLConnection;
import com.uqac.stablemanager.utils.PasswordManager;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class MemberService extends CommonDao<MemberModel> {
    private final static String TABLE = "Member";

    public MemberService(Connection connection) {
        super(connection);
    }

    public MemberModel findById(int id) {
        try {
            Map<String, Object> condition = new HashMap<>();
            condition.put("id", id);
            return new DatabaseHelper<>(connection, this::buildMemberFromResultSet).findBy("ProfileMember", condition);
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public MemberModel findByEmail(String email) {
        try {
            Map<String, Object> condition = new HashMap<>();
            condition.put("email", email);
            return new DatabaseHelper<>(connection, this::buildMemberFromResultSet).findBy("ProfileMember", condition);
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
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
            String hashPassword = PasswordManager.hash(member.getPassword());
            statement.setString(7, hashPassword);
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

    private List<MemberModel> list(PreparedStatement statement) throws SQLException {
        List<MemberModel> members = new ArrayList<>();
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            members.add(buildMemberFromResultSet(result));
        }
        return members;
    }

    public List<MemberModel> list() {
        try {
            return new DatabaseHelper<>(connection, this::buildMemberFromResultSet).list("ProfileMember");
        } catch (SQLException exception) {
            return null;
        }
    }

    public List<MemberModel> list(RoleModel roleFilter) {
        List<MemberModel> members = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ProfileMember WHERE role_name = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setString(1, roleFilter.getName());
            members = list(statement);
        } catch (SQLException exception) {
            System.err.println(exception);
        }
        return members;
    }

    private MemberModel buildMemberFromResultSet(ResultSet result) {
        MemberModel member = new MemberModel();
        try {
            member.setId(result.getInt("id"));
            member.setEmail(result.getString("email"));
            member.setFirstName(result.getString("first_name"));
            member.setLastName(result.getString("last_name"));
            member.setBirthDate(result.getDate("birth_date"));
            member.setRegisterAt(result.getDate("register_at"));
            member.setPassword(result.getString("passwd"));
            member.setPostalAddress(result.getString("postal_address"));
            RoleModel role = new RoleService(MySQLConnection.getConnection()).findByName(result.getString("role_name"));
            member.setRole(role);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
//        boolean isAdmin = result.getBoolean("isAdmin");
//        if (isAdmin) {
//            member = new AdminModel(member);
//        }
        return member;
    }
}
