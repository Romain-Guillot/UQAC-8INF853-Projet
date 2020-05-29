package com.uqac.stablemanager.member.action;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.MemberService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import com.uqac.stablemanager.utils.MySQLConnection;

public class MemberProfileCreationAction extends AuthenticatedAction {

    private MemberModel member;

    @Override
    public String execute() {
        boolean success = false;
        if (member != null)
            success = new MemberService(MySQLConnection.getConnection()).create(member);
        return success ? SUCCESS : ERROR;
    }

    @Override
    public void validate() {
        if (member.getEmail() == null) {
            addFieldError("member.email", "Email cannot be empty");
        } else {
            MemberModel memberWithSameEmail = new MemberService(MySQLConnection.getConnection()).findByEmail(member.getEmail());
            if (memberWithSameEmail != null) {
                addFieldError("member.email", "Email already exists");
            }
        }
    }

    public MemberModel getMember() {
        return member;
    }

    public void setMember(MemberModel member) {
        this.member = member;
    }
}
