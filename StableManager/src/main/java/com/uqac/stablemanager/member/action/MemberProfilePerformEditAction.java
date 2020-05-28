package com.uqac.stablemanager.member.action;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.MemberService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import com.uqac.stablemanager.utils.MySQLConnection;

public class MemberProfilePerformEditAction extends AuthenticatedAction {
    private String memberID;
    private MemberModel member;
    private String newPassword;

    @Override
    public String execute() {
        member.setId(memberID);
        boolean success = new MemberService(MySQLConnection.getConnection()).update(member);
        return success ? SUCCESS : ERROR;
    }

    public String updatePassword() {
        boolean success = new MemberService(MySQLConnection.getConnection()).changePassword(memberID, newPassword);
        return success ? SUCCESS : ERROR;
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

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMemberID() {
        return memberID;
    }
}
