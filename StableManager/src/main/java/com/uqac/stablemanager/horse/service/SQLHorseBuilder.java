package com.uqac.stablemanager.horse.service;

import com.uqac.stablemanager.horse.model.HorseModel;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.IMemberService;
import com.uqac.stablemanager.utils.sql.SQLModelBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;

public class SQLHorseBuilder extends SQLModelBuilder<HorseModel> {
    @Autowired  IMemberService memberService;

    @Override
    public void fromResultSet(ResultSet resultSet) throws Exception {
        model = new HorseModel();
        model.setId(resultSet.getInt("id"));
        model.setName(resultSet.getString("name"));
        model.setBirthDate(resultSet.getDate("birth_date"));
        MemberModel owner = memberService.findById(resultSet.getInt("profile_member_id"));
        model.setOwner(owner);
    }
}
