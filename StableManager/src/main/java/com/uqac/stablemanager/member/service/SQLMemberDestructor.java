package com.uqac.stablemanager.member.service;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.utils.sql.SQLModelDestructor;

import java.util.HashMap;
import java.util.Map;

public class SQLMemberDestructor implements SQLModelDestructor<MemberModel> {
    @Override
    public Map<String, Object> destruct(MemberModel model) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("profile_id", model.getId());
        map.put("email", model.getEmail());
        map.put("first_name", model.getFirstName());
        map.put("last_name", model.getLastName());
        map.put("birth_date", model.getBirthDate());
        map.put("register_at", model.getRegisterAt());
        map.put("passwd", model.getPassword());
        map.put("postal_address", model.getPostalAddress());
        return map;
    }
}
