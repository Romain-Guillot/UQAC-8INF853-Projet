package com.uqac.stablemanager.booking.service;

import com.uqac.stablemanager.booking.model.BookingModel;
import com.uqac.stablemanager.horse.model.HorseModel;
import com.uqac.stablemanager.horse.service.HorseService;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.IMemberService;
import com.uqac.stablemanager.utils.CommonDao;
import com.uqac.stablemanager.utils.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MySQLBookingService extends CommonDao<BookingModel> implements IBookingService {

    @Autowired IMemberService memberService;
    @Autowired HorseService horseService;

    @Override
    public List<BookingModel> list() throws Exception {
        String query = "SELECT * FROM Booking";
        List<BookingModel> bookings = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            MemberModel memberModel = memberService.findById(result.getInt("profile_id"));
            HorseModel horseModel = horseService.findById(result.getInt("resource_id"));
            bookings.add(new MySQLBookingAdapter(result, memberModel, horseModel));
        }
        return bookings;
    }

    @Override
    public List<BookingModel> listByMember(MemberModel member) throws Exception {
        String query = "SELECT * FROM Booking WHERE profile_id = ?" ;
        List<BookingModel> bookings = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        statement.setInt(1, member.getId());
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            MemberModel memberModel = memberService.findById(result.getInt("profile_id"));
            HorseModel horseModel = horseService.findById(result.getInt("resource_id"));
            bookings.add(new MySQLBookingAdapter(result, memberModel, horseModel));
        }
        return bookings;
    }

    @Override
    public BookingModel findById(int id) throws Exception {
        String query = "SELECT * FROM Booking WHERE booking_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            MemberModel memberModel = memberService.findById(result.getInt("profile_id"));
            HorseModel horseModel = horseService.findById(result.getInt("resource_id"));
            return new MySQLBookingAdapter(result, memberModel, horseModel);
        } else {
            throw new NotFoundException();
        }
    }
}
