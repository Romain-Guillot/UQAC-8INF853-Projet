package com.uqac.stablemanager.booking.service;

import com.uqac.stablemanager.booking.model.BookingModel;
import com.uqac.stablemanager.utils.CommonDao;
import com.uqac.stablemanager.utils.NotFoundException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MySQLBookingService extends CommonDao<BookingModel> implements IBookingService {

    @Override
    public List<BookingModel> list() throws Exception {
        String query = "SELECT * FROM Booking B " +
                "INNER JOIN ProfileMember P " +
                "ON B.profile_id = P.id " +
                "INNER JOIN Horse R " +
                "ON B.resource_id = R.id";
        List<BookingModel> bookings = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            bookings.add(new MySQLBookingAdapter(result));
        }
        return bookings;
    }

    @Override
    public BookingModel findById(int id) throws Exception {
        String query = "SELECT * FROM Booking B " +
                "INNER JOIN ProfileMember P " +
                "ON B.profile_id = P.id " +
                "INNER JOIN Horse R " +
                "ON B.resource_id = R.id " +
                "WHERE B.id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            return new MySQLBookingAdapter(result);
        } else {
            throw new NotFoundException();
        }
    }
}
