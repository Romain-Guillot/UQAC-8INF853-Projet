package com.uqac.stablemanager.member.action;

import com.uqac.stablemanager.auth.service.IAuthenticationService;
import com.uqac.stablemanager.member.service.MemberService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 *
 */
public class MemberDeleteAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired private IAuthenticationService authenticationService;
    @Autowired private MemberService memberService;

    private int memberID;

    @PreAuthorize("hasAuthority('WRITE_ALL_PROFILES')")
    public String performDelete() {
        return deleteWorker(memberID) ? SUCCESS : INPUT;
    }

    public String performDeleteConnectedUser() {
        return deleteWorker(getUser().getId()) ? SUCCESS : INPUT;
    }

    private boolean deleteWorker(int memberID) {
        int userID = getUser().getId();
        boolean success = memberService.delete(memberID);
        if (success && memberID == userID) {
            authenticationService.logout();
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
