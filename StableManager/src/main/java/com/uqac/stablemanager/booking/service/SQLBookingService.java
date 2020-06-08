package com.uqac.stablemanager.booking.service;

import com.uqac.stablemanager.booking.model.BookingModel;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.utils.CommonDao;
import com.uqac.stablemanager.utils.sql.NewSQLTableHelper;
import com.uqac.stablemanager.utils.sql.SQLModelBuilder;
import com.uqac.stablemanager.utils.sql.SQLModelDestructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Map;


public class SQLBookingService extends CommonDao<BookingModel> implements IBookingService {
    @Autowired SQLModelBuilder<BookingModel> bookingBuilder;
    @Autowired SQLModelDestructor<BookingModel> bookingDestructor;

    @Override
    public List<BookingModel> list() throws Exception {
        return getSQLHelper().list();
    }

    @Override
    public List<BookingModel> listByMember(MemberModel member) throws Exception {
        Map<String, Object> condition = Collections.singletonMap("profile_id", member.getId());
        return getSQLHelper().list(condition);
    }

    @Override
    public BookingModel findById(int id) throws Exception {
        Map<String, Object> condition = Collections.singletonMap("booking_id", id);
        return getSQLHelper().findBy(condition);
    }

    private NewSQLTableHelper<BookingModel> getSQLHelper() {
        return new NewSQLTableHelper<>(connection, "Booking", bookingBuilder, bookingDestructor);
    }
}
