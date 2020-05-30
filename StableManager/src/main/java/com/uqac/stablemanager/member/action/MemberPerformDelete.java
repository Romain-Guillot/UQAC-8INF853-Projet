package com.uqac.stablemanager.member.action;

import com.uqac.stablemanager.auth.service.MySQLAuthenticationService;
import com.uqac.stablemanager.member.service.MemberService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import com.uqac.stablemanager.utils.MySQLConnection;

/**
 *
 */
public class MemberPerformDelete extends AuthenticatedAction {
    private int memberID;

//    @PreAuthorize("hasAuthority('WRITE_ALL_PROFILES')")
    public String execute() {
        return performDelete(memberID) ? SUCCESS : INPUT;
    }

    public String deleteConnectedUser() {
        return performDelete(getUser().getId()) ? SUCCESS : INPUT;
    }

    private boolean performDelete(int memberID) {
        int userID = getUser().getId();
        boolean success = new MemberService(MySQLConnection.getConnection()).delete(memberID);
        if (success && memberID == userID) {
            new MySQLAuthenticationService(MySQLConnection.getConnection()).logout();
        }
        return success;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
}
