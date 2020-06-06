package com.uqac.stablemanager.booking.model;

import com.uqac.stablemanager.horse.model.HorseModel;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.utils.TimeSlot;

public class BookingModel {
    protected int id;
    protected MemberModel member;
    protected HorseModel resource;
    protected TimeSlot timeSlot;

    public BookingModel() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MemberModel getMember() {
        return member;
    }

    public void setMember(MemberModel member) {
        this.member = member;
    }

    public HorseModel getResource() {
        return resource;
    }

    public void setResource(HorseModel resource) {
        this.resource = resource;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }
}
