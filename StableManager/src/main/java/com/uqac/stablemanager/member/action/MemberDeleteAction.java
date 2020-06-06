package com.uqac.stablemanager.member.action;

import com.uqac.stablemanager.auth.service.IAuthenticationService;
import com.uqac.stablemanager.member.service.IMemberService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 *
 */
public class MemberDeleteAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired private IAuthenticationService authenticationService;
    @Autowired private IMemberService memberService;

    private int memberID;

    @PreAuthorize("@controlBasedService.hasAccess('WRITE_ALL_PROFILES')")
    public String performDelete() throws Exception{
        int userID = getUser().getId();
        memberService.delete(memberID);
        if (memberID == userID) {
            authenticationService.logout();
        }
        return SUCCESS;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
}
