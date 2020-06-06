package com.uqac.stablemanager.equipment.service;

import com.uqac.stablemanager.equipment.model.EquipmentModel;
import com.uqac.stablemanager.security.service.PermissionService;
import com.uqac.stablemanager.utils.CommonDao;
import com.uqac.stablemanager.utils.sql.SQLTableOperationsHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public class EquipmentService extends CommonDao<EquipmentModel> {

    @Autowired PermissionService permissionService;
    private final SQLTableOperationsHelper<EquipmentModel> tableOperationsHelper;

    public EquipmentService() {
        tableOperationsHelper = new SQLTableOperationsHelper<>(connection, "Equipment", this::fromResultSet, this::toMap);
    }

    public List<EquipmentModel> list() {
        try {
            return tableOperationsHelper.list();
        } catch (SQLException exception) {
            return null;
        }
    }

    public EquipmentModel findById(int id) {
        try {
            Map<String, Object> condition = new HashMap<>();
            condition.put("id", id);
            return tableOperationsHelper.findBy(condition);
        } catch (SQLException exception) {
            log(Level.SEVERE, null, exception);
            return null;
        }
    }

    public boolean create(EquipmentModel equipment) {
        try{
            Object key = tableOperationsHelper.create(equipment);
            equipment.setId(((BigInteger) key).intValue());
            return true;
        } catch (SQLException exception) {
            log(Level.SEVERE, null, exception);
            return false;
        }
    }


    public boolean update(EquipmentModel equipment) {
        try {
            Map<String, Object> primaryKey = Collections.singletonMap("id", equipment.getId());
            return tableOperationsHelper.update(primaryKey, equipment);
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

    private HashMap<String, Object> toMap(EquipmentModel equipmentModel) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", equipmentModel.getId());
        map.put("type", equipmentModel.getType());
        map.put("model", equipmentModel.getModel());
        map.put("price", equipmentModel.getPrice());
        map.put("profile_member_id", equipmentModel.getMemberId());
        return map;
    }

    private EquipmentModel fromResultSet(ResultSet result) {
        EquipmentModel equipment = new EquipmentModel();
        try {
            equipment.setId(result.getInt("id"));
            equipment.setType(result.getString("type"));
            equipment.setModel(result.getString("model"));
            equipment.setPrice(result.getFloat("price"));
            equipment.setMemberId(result.getInt("profile_member_id"));
        } catch (SQLException exception) {
            log(Level.SEVERE, null, exception);
        }
        return equipment;
    }
}
