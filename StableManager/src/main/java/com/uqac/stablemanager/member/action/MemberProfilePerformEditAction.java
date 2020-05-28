package com.uqac.stablemanager.member.action;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.MemberService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import com.uqac.stablemanager.utils.MySQLConnection;

public class MemberProfilePerformEditAction extends AuthenticatedAction {

    private MemberModel member;

    @Override
    public String execute() {
        member.setId("1");
        boolean success = new MemberService(MySQLConnection.getConnection()).update(member);
        return success ? SUCCESS : ERROR;
    }

    public MemberModel getMember() {
        return member;
    }

    public void setMember(MemberModel member) {
        this.member = member;
    }
}
