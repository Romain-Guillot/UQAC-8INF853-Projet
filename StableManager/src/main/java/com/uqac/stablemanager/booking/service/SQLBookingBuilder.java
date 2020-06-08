package com.uqac.stablemanager.booking.service;

import com.uqac.stablemanager.booking.model.BookingModel;
import com.uqac.stablemanager.horse.model.HorseModel;
import com.uqac.stablemanager.horse.service.HorseService;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.IMemberService;
import com.uqac.stablemanager.utils.TimeSlot;
import com.uqac.stablemanager.utils.sql.SQLModelBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.util.Date;

public class SQLBookingBuilder extends SQLModelBuilder<BookingModel> {
    @Autowired private IMemberService memberService;
    @Autowired private HorseService horseService;


    @Override
    public void fromResultSet(ResultSet resultSet) throws Exception {
        reset();
        model = new BookingModel();
        model.setId(resultSet.getInt("booking_id"));
        Date begin = resultSet.getDate("begin");
        Date end = resultSet.getDate("end");
        model.setTimeSlot(new TimeSlot(begin, end));
        MemberModel memberModel = memberService.findById(resultSet.getInt("profile_id"));
        HorseModel horseModel = horseService.findById(resultSet.getInt("resource_id"));
        model.setMember(memberModel);
        model.setResource(horseModel);
    }
}
