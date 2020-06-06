package com.uqac.stablemanager.booking.service;

import com.uqac.stablemanager.booking.model.BookingModel;

import java.sql.SQLException;
import java.util.List;

public interface IBookingService {
    List<BookingModel> list() throws Exception;

    BookingModel findById(int id) throws Exception;
}