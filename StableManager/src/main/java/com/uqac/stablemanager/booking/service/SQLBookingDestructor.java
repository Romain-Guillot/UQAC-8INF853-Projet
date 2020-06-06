package com.uqac.stablemanager.booking.service;

import com.uqac.stablemanager.booking.model.BookingModel;
import com.uqac.stablemanager.utils.sql.SQLModelDestructor;

import java.util.Map;

public class SQLBookingDestructor implements SQLModelDestructor<BookingModel> {

    @Override
    public Map<String, Object> destruct(BookingModel model) {
        return null;
    }
}
