package com.uqac.stablemanager.member.action;

import com.opensymphony.xwork2.ActionSupport;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.MemberService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import com.uqac.stablemanager.utils.MySQLConnection;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class MemberProfileViewAction extends AuthenticatedAction {
    private String memberID;
    private MemberModel member;

    @Override
    public String execute() throws Exception {
        member = new MemberService(MySQLConnection.getConnection()).findById(memberID);
        return SUCCESS;
    }

    public MemberModel getMember() {
        return member;
    }

    public void setMember(MemberModel member) {
        this.member = member;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }
}
