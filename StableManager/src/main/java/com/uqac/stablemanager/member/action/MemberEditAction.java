package com.uqac.stablemanager.member.action;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.MemberService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberEditAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired
    private MemberService memberService;

    private int memberID;
    private MemberModel member;
    private String newPassword;

    public String view() {
        member = memberService.findById(memberID);
        return SUCCESS;
    }

    public String performUpdate() {
        member.setId(memberID);
        boolean success = memberService.update(member);
        return success ? SUCCESS : ERROR;
    }

    public String performUpdatePassword() {
        boolean success = memberService.changePassword(memberID, newPassword);
        return success ? SUCCESS : ERROR;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public MemberModel getMember() {
        return member;
    }

    public void setMember(MemberModel member) {
        this.member = member;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
