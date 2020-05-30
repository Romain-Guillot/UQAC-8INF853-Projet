package com.uqac.stablemanager.member.action;

import com.uqac.stablemanager.auth.service.AuthenticationService;
import com.uqac.stablemanager.member.service.MemberService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import com.uqac.stablemanager.utils.MySQLConnection;

public class MemberPerformDelete extends AuthenticatedAction {
    private int memberID;

    @Override
    public String execute() {
        int userID = getUser().getId();
        boolean success = new MemberService(MySQLConnection.getConnection()).delete(memberID);
        if (success && memberID == userID) {
            new AuthenticationService(MySQLConnection.getConnection()).logout();
        }
        return success ? SUCCESS : INPUT;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
}
