package com.uqac.stablemanager.horse.service;

import com.uqac.stablemanager.horse.model.HorseModel;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.security.service.PermissionService;
import com.uqac.stablemanager.utils.CommonDao;
import com.uqac.stablemanager.utils.SQLTableOperationsHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;

public class HorseService extends CommonDao<HorseModel> {

    @Autowired PermissionService permissionService;
    private final SQLTableOperationsHelper<HorseModel> tableOperationsHelper;

    public HorseService() {
        tableOperationsHelper = new SQLTableOperationsHelper<>(connection, "Horse", this::fromResultSet, this::toMap);
    }

    public List<HorseModel> list() {
        try {
            return tableOperationsHelper.list();
        } catch (SQLException exception) {
            return null;
        }
    }

    public HorseModel findById(int id) {
        try {
            Map<String, Object> condition = new HashMap<>();
            condition.put("id", id);
            return tableOperationsHelper.findBy(condition);
        } catch (SQLException exception) {
            log(Level.SEVERE, null, exception);
            return null;
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

    private HashMap<String, Object> toMap(HorseModel horseModel) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", horseModel.getId());
        map.put("name", horseModel.getName());
        map.put("birth_date", horseModel.getBirthDate());
        map.put("profile_member_id", horseModel.getMemberId());
        return map;
    }

    private HorseModel fromResultSet(ResultSet result) {
        HorseModel horse = new HorseModel();
        try {
            horse.setId(result.getInt("id"));
            horse.setName(result.getString("name"));
            horse.setBirthDate(result.getDate("birth_date"));
            horse.setMemberId(result.getInt("profile_member_id"));
        } catch (SQLException exception) {
            log(Level.SEVERE, null, exception);
        }
        return horse;
    }
}
