package com.uqac.stablemanager.booking.service;

import com.uqac.stablemanager.booking.model.BookingModel;
import com.uqac.stablemanager.horse.model.HorseModel;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.utils.TimeSlot;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MySQLBookingAdapter extends BookingModel {

    public MySQLBookingAdapter(ResultSet resultSet, MemberModel member, HorseModel resource) throws SQLException {
        setId(resultSet.getInt("booking_id"));
        Date begin = resultSet.getDate("begin");
        Date end = resultSet.getDate("end");
        setTimeSlot(new TimeSlot(begin, end));
        setMember(member);;
        setResource(resource);
    }
}
