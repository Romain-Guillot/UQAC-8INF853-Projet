package com.uqac.stablemanager.member.service;

import com.uqac.stablemanager.member.exception.MemberCollisionException;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.security.model.RoleModel;
import com.uqac.stablemanager.utils.*;
import com.uqac.stablemanager.utils.sql.NewSQLTableHelper;
import com.uqac.stablemanager.utils.sql.SQLModelBuilder;
import com.uqac.stablemanager.utils.sql.SQLModelDestructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.sql.*;
import java.util.*;

public class SQLMemberService extends CommonDao<MemberModel> implements IMemberService {
    @Autowired private PasswordManager passwordManager;
    @Autowired private SQLModelBuilder<MemberModel> memberBuilder;
    @Autowired private SQLModelDestructor<MemberModel> memberDestructor;

    public MemberModel findById(int id) throws Exception {
        Map<String, Object> condition = new HashMap<>();
        condition.put("profile_id", id);
        return getSQLHelper().findBy(condition);
    }

    public MemberModel findByEmail(String email) throws Exception {
        Map<String, Object> condition = new HashMap<>();
        condition.put("email", email);
        return getSQLHelper().findBy(condition);
    }

    public List<MemberModel> list() throws Exception {
        return getSQLHelper().list();
    }

    public List<MemberModel> list(RoleModel roleFilter) throws Exception {
        Map<String, Object> condition = Collections.singletonMap("role_name", roleFilter.getName());
        return getSQLHelper().list(condition);
    }

    public void update(MemberModel member) throws Exception {
        try {
            Map<String, Object> primaryKey = Collections.singletonMap("profile_id", member.getId());
            getSQLHelper().update(primaryKey, member);
        } catch (SQLIntegrityConstraintViolationException exception) {
            throw new MemberCollisionException();
        }
    }

    public void delete(int id) throws Exception {
        Map<String, Object> condition = Collections.singletonMap("profile_id", id);
        getSQLHelper().delete(condition);
    }

    public void create(MemberModel member) throws Exception {
        try {
            member.setRegisterAt(Calendar.getInstance().getTime());
            member.setPassword(passwordManager.hash(member.getPassword()));
            Object key = getSQLHelper().create(member);
            member.setId(((BigInteger) key).intValue());
        } catch (SQLIntegrityConstraintViolationException exception) {
            throw new MemberCollisionException();
        }
    }

    public void changePassword(int memberID, String newPassword) throws Exception {
        String hashPassword = passwordManager.hash(newPassword);
        PreparedStatement statement = connection.prepareStatement("UPDATE ProfileMember SET " +
                "passwd=?" +
                "WHERE id = ?");
        statement.setString(1, hashPassword);
        statement.setInt(2, memberID);
        if (statement.executeUpdate() != 1) {
            throw new Exception();
        }
        statement.close();
    }

    private NewSQLTableHelper<MemberModel> getSQLHelper() {
        return new NewSQLTableHelper<>(connection, "ProfileMember", memberBuilder, memberDestructor);
    }
}
