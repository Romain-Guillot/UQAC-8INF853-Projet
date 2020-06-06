package com.uqac.stablemanager.booking.action;

import com.uqac.stablemanager.booking.model.BookingModel;
import com.uqac.stablemanager.booking.service.IBookingService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;

public class BookingViewAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired private IBookingService bookingService;

    private int bookingID;
    private BookingModel booking;

    public BookingViewAction() { }

    @Override
    public String execute() throws Exception {
        booking = bookingService.findById(bookingID);
        return SUCCESS;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public BookingModel getBooking() {
        return booking;
    }

    public void setBooking(BookingModel booking) {
        this.booking = booking;
    }
}
