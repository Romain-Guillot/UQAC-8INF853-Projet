package com.uqac.stablemanager.member.service;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.security.service.RoleService;
import com.uqac.stablemanager.utils.CommonDao;
import com.uqac.stablemanager.utils.DatabaseHelper;
import com.uqac.stablemanager.utils.MySQLConnection;
import com.uqac.stablemanager.utils.PasswordManager;

import java.sql.*;
import java.util.*;

public class MemberService extends CommonDao<MemberModel> {
    private final static String TABLE = "ProfileMember";

    public MemberService(Connection connection) {
        super(connection);
    }

    public MemberModel findById(int id) {
        try {
            Map<String, Object> condition = new HashMap<>();
            condition.put("id", id);
            return new DatabaseHelper<>(connection, this::fromResultSet).findBy(TABLE, condition);
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public MemberModel findByEmail(String email) {
        try {
            Map<String, Object> condition = new HashMap<>();
            condition.put("email", email);
            return new DatabaseHelper<>(connection, this::fromResultSet).findBy(TABLE, condition);
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public boolean update(MemberModel member) {
        try {
            Map<String, Object> primaryKey = Collections.singletonMap("id", member.getId());
            Map<String, Object> values = toMap(member);
            return new DatabaseHelper<>(connection, this::fromResultSet).update("ProfileMember", primaryKey, values);
        } catch (SQLException exception) {
            System.err.println(exception);
            return  false;
        }
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
        try {
            Map<String, Object> condition = new HashMap<>();
            condition.put("id", id);
            return new DatabaseHelper<>(connection, this::fromResultSet).delete(TABLE, condition);
        } catch (SQLException exception) {
            return false;
        }
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


    public List<MemberModel> list() {
        try {
            return new DatabaseHelper<>(connection, this::fromResultSet).list("ProfileMember");
        } catch (SQLException exception) {
            return null;
        }
    }

    public List<MemberModel> list(RoleModel roleFilter) {
        try {
            Map<String, Object> condition = new HashMap<>();
            condition.put("role_name", roleFilter.getName());
            return new DatabaseHelper<>(connection, this::fromResultSet).list("ProfileMember", condition);
        } catch (SQLException exception) {
            return null;
        }
    }


    private HashMap<String, Object> toMap(MemberModel memberModel) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", memberModel.getId());
        map.put("email", memberModel.getEmail());
        map.put("first_name", memberModel.getFirstName());
        map.put("last_name", memberModel.getLastName());
        map.put("birth_date", memberModel.getBirthDate());
        map.put("register_at", memberModel.getRegisterAt());
        map.put("passwd", memberModel.getPassword());
        map.put("postal_address", memberModel.getPostalAddress());
        return map;
    }

    private MemberModel fromResultSet(ResultSet result) {
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