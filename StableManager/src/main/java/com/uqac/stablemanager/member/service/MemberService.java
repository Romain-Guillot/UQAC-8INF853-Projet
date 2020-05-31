package com.uqac.stablemanager.member.service;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.security.service.RoleService;
import com.uqac.stablemanager.utils.CommonDao;
import com.uqac.stablemanager.utils.SQLTableOperationsHelper;
import com.uqac.stablemanager.utils.PasswordManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MemberService extends CommonDao<MemberModel> {
    @Autowired private PasswordManager passwordManager;
    @Autowired private RoleService roleService;

    private final SQLTableOperationsHelper<MemberModel> tableOperationsHelper;

    public MemberService() {
        tableOperationsHelper = new SQLTableOperationsHelper<>(connection, "ProfileMember", this::fromResultSet, this::toMap);
    }

    public MemberModel findById(int id) {
        try {
            Map<String, Object> condition = new HashMap<>();
            condition.put("id", id);
            return tableOperationsHelper.findBy(condition);
        } catch (SQLException exception) {
            log(Level.SEVERE, null, exception);
            return null;
        }
    }

    public MemberModel findByEmail(String email) {
        try {
            Map<String, Object> condition = new HashMap<>();
            condition.put("email", email);
            return tableOperationsHelper.findBy(condition);
        } catch (SQLException exception) {
            log(Level.SEVERE, null, exception);
            return null;
        }
    }

    public List<MemberModel> list() {
        try {
            return tableOperationsHelper.list();
        } catch (SQLException exception) {
            return null;
        }
    }

    public List<MemberModel> list(RoleModel roleFilter) {
        try {
            Map<String, Object> condition = new HashMap<>();
            condition.put("role_name", roleFilter.getName());
            return tableOperationsHelper.list(condition);
        } catch (SQLException exception) {
            return null;
        }
    }

    public boolean update(MemberModel member) {
        try {
            Map<String, Object> primaryKey = Collections.singletonMap("id", member.getId());
            return tableOperationsHelper.update(primaryKey, member);
        } catch (SQLException exception) {
            log(Level.SEVERE, null, exception);
            return  false;
        }
    }

    public boolean delete(int id) {
        try {
            Map<String, Object> condition = new HashMap<>();
            condition.put("id", id);
            return tableOperationsHelper.delete(condition);
        } catch (SQLException exception) {
            log(Level.SEVERE, null, exception);
            return false;
        }
    }

    public boolean create(MemberModel member) {
        try{
            member.setRegisterAt(Calendar.getInstance().getTime());
            member.setPassword(passwordManager.hash(member.getPassword()));
            Object key = tableOperationsHelper.create(member);
            member.setId(((BigInteger) key).intValue());
            return true;
        } catch (SQLException exception) {
            log(Level.SEVERE, null, exception);
            return false;
        }
    }

    public boolean changePassword(int memberID, String newPassword) {
        boolean success = false;
        try{
            String hashPassword = passwordManager.hash(newPassword);
            PreparedStatement statement = connection.prepareStatement("UPDATE ProfileMember SET " +
                    "passwd=?" +
                    "WHERE id = ?");
            statement.setString(1, hashPassword);
            statement.setInt(2, memberID);
            int res = statement.executeUpdate();
            success = res == 1;
            statement.close();
        }catch (SQLException exception) {
            log(Level.SEVERE, null, exception);
        }
        return success;
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
            RoleModel role = roleService.findByName(result.getString("role_name"));
            member.setRole(role);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return member;
    }
}
