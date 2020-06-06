package com.uqac.stablemanager.booking.service;

import com.uqac.stablemanager.booking.model.BookingModel;
import com.uqac.stablemanager.utils.TimeSlot;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MySQLBookingAdapter extends BookingModel {

    public MySQLBookingAdapter(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.member = null;
        this.resource = null;
        Date begin = resultSet.getDate("begin");
        Date end = resultSet.getDate("end");
        this.timeSlot = new TimeSlot(begin, end);
    }
}
