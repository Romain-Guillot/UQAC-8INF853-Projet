package com.uqac.stablemanager.member.action;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.MemberService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

public class MemberViewAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired MemberService memberService;

    private int memberID;
    private MemberModel member;

    @Override
    @PreAuthorize("@controlBasedService.hasAccess('READ_ALL_PROFILES')")
    public String execute() {
        member = memberService.findById(memberID);
        return member == null ? ERROR : SUCCESS;
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
}
