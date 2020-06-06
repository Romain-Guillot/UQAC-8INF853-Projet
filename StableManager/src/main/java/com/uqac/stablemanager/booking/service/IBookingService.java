package com.uqac.stablemanager.booking.service;

import com.uqac.stablemanager.booking.model.BookingModel;
import com.uqac.stablemanager.member.model.MemberModel;

import java.util.List;

public interface IBookingService {
    List<BookingModel> list() throws Exception;

    List<BookingModel> listByMember(MemberModel member) throws Exception;

    BookingModel findById(int id) throws Exception;

}