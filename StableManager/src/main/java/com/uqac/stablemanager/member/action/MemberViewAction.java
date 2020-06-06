package com.uqac.stablemanager.member.action;

import com.uqac.stablemanager.booking.model.BookingModel;
import com.uqac.stablemanager.booking.service.IBookingService;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.IMemberService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public class MemberViewAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired IMemberService memberService;
    @Autowired IBookingService bookingService;

    private int memberID;
    private MemberModel member;
    private List<BookingModel> bookings;

    @Override
    @PreAuthorize("@controlBasedService.hasAccess('READ_ALL_PROFILES')")
    public String execute() throws Exception {
        member = memberService.findById(memberID);
        bookings = bookingService.listByMember(member);
        return member == null ? ERROR_404 : SUCCESS;
    }

    public MemberModel getMember() {
        return member;
    }

    public void setMember(MemberModel member) {
        this.member = member;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public List<BookingModel> getBookings() {
        return bookings;
    }
}
