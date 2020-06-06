package com.uqac.stablemanager.member.action;

import com.uqac.stablemanager.auth.service.IAuthenticationService;
import com.uqac.stablemanager.member.service.IMemberService;
import com.uqac.stablemanager.member.service.MySQLMemberService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 *
 */
public class MemberDeleteAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired private IAuthenticationService authenticationService;
    @Autowired private IMemberService mySQLMemberService;

    private int memberID;

    @PreAuthorize("@controlBasedService.hasAccess('WRITE_ALL_PROFILES')")
    public String performDelete() throws Exception{
        int userID = getUser().getId();
        boolean success = mySQLMemberService.delete(memberID);
        if (success && memberID == userID) {
            authenticationService.logout();
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
