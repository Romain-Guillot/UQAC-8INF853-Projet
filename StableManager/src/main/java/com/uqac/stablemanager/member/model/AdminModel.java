package com.uqac.stablemanager.member.model;

import com.uqac.stablemanager.utils.TimeSlot;

import java.util.List;

public class AdminModel extends MemberModel {
    private List<TimeSlot> planning;

    public AdminModel() {

    }

    public AdminModel(MemberModel member) {
        super(member);
    }
}
