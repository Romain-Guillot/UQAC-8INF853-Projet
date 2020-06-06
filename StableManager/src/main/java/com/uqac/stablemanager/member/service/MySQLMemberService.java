package com.uqac.stablemanager.member.service;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.security.service.RoleService;
import com.uqac.stablemanager.utils.CommonDao;
import com.uqac.stablemanager.utils.NotFoundException;
import com.uqac.stablemanager.utils.SQLTableOperationsHelper;
import com.uqac.stablemanager.utils.PasswordManager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.management.relation.Role;
import java.math.BigInteger;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;

public class MySQLMemberService extends CommonDao<MemberModel> implements IMemberService {
    @Autowired private PasswordManager passwordManager;
    @Autowired private RoleService roleService;

    private final SQLTableOperationsHelper<MemberModel> tableOperationsHelper;

    public MySQLMemberService() {
        tableOperationsHelper = new SQLTableOperationsHelper<>(connection, "ProfileMember", null, this::toMap);
    }

    public MemberModel findById(int id) throws Exception {
        String query = "SELECT * FROM ProfileMember P LEFT JOIN Role R ON P.role_name = R.name WHERE P.profile_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            RoleModel role = roleService.findByName(resultSet.getString("role_name"));
            return new MySQLMemberAdapter(resultSet, role);
        } else {
            throw new NotFoundException();
        }
    }

    public MemberModel findByEmail(String email) throws Exception{
        String query = "SELECT * FROM ProfileMember P LEFT JOIN Role R ON P.role_name = R.name WHERE P.email = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            RoleModel role = roleService.findByName(resultSet.getString("role_name"));
            return new MySQLMemberAdapter(resultSet, role);
        } else {
            throw new NotFoundException();
        }
    }

    public List<MemberModel> list() throws Exception {
        List<MemberModel> members = new ArrayList<>();
        String query = "SELECT * FROM ProfileMember";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            RoleModel role = roleService.findByName(resultSet.getString("role_name"));
            members.add(new MySQLMemberAdapter(resultSet, role));
        }
        return members;
    }

    public List<MemberModel> list(RoleModel roleFilter) throws Exception {
        List<MemberModel> members = new ArrayList<>();
        String query = "SELECT * FROM ProfileMember WHERE role_name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, roleFilter.getName());
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            RoleModel role = roleService.findByName(resultSet.getString("role_name"));
            members.add(new MySQLMemberAdapter(resultSet, role));
        }
        return members;
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
            condition.put("profile_id", id);
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
        map.put("profile_id", memberModel.getId());
        map.put("email", memberModel.getEmail());
        map.put("first_name", memberModel.getFirstName());
        map.put("last_name", memberModel.getLastName());
        map.put("birth_date", memberModel.getBirthDate());
        map.put("register_at", memberModel.getRegisterAt());
        map.put("passwd", memberModel.getPassword());
        map.put("postal_address", memberModel.getPostalAddress());
        return map;
    }
}
