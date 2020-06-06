package com.uqac.stablemanager.booking.service;

import com.uqac.stablemanager.booking.model.BookingModel;
import com.uqac.stablemanager.horse.model.HorseModel;
import com.uqac.stablemanager.horse.service.HorseService;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.IMemberService;
import com.uqac.stablemanager.utils.sql.SQLModelBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;

public class SQLBookingBuilder implements SQLModelBuilder<BookingModel> {
    @Autowired private IMemberService memberService;
    @Autowired private HorseService horseService;
    private BookingModel model;

    @Override
    public void reset() {
        model = null;
    }

    @Override
    public BookingModel getModel() {
        return model;
    }

    @Override
    public void fromResultSet(ResultSet resultSet) throws Exception {
        reset();
        model = new BookingModel();
        model.setId(resultSet.getInt("booking_id"));
        MemberModel memberModel = memberService.findById(resultSet.getInt("profile_id"));
        HorseModel horseModel = horseService.findById(resultSet.getInt("resource_id"));
        model.setMember(memberModel);
        model.setResource(horseModel);
    }
}
