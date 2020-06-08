package com.uqac.stablemanager.horse.service;

import com.uqac.stablemanager.horse.model.HorseModel;
import com.uqac.stablemanager.utils.sql.SQLModelDestructor;

import java.util.HashMap;
import java.util.Map;

public class SQLHorseDestructor implements SQLModelDestructor<HorseModel> {
    @Override
    public Map<String, Object> destruct(HorseModel model) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", model.getId());
        map.put("name", model.getName());
        map.put("birth_date", model.getBirthDate());
        map.put("profile_member_id", model.getOwner().getId());
        return map;
    }
}
