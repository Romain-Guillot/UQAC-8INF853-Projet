package com.uqac.stablemanager.member.action;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.utils.AuthenticatedAction;

public class MemberProfileEditAction extends AuthenticatedAction {

    private String memberID;
    private MemberModel member;
    private String newPassword;

    @Override
    public String execute() throws Exception {
        member = getUser();
        return SUCCESS;
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
