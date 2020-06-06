package com.uqac.stablemanager.booking.action;

import com.uqac.stablemanager.booking.model.BookingModel;
import com.uqac.stablemanager.booking.service.IBookingService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookingListViewAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired private IBookingService bookingService;

    private List<BookingModel> bookings;

    public BookingListViewAction() { }

    @Override
    public String execute() throws Exception {
        bookings = bookingService.list();
        return SUCCESS;
    }

    public List<BookingModel> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingModel> bookings) {
        this.bookings = bookings;
    }
}
