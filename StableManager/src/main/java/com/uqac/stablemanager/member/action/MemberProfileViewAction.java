package com.uqac.stablemanager.member.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.MemberService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import com.uqac.stablemanager.utils.MySQLConnection;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Map;


public class MemberProfileViewAction extends AuthenticatedAction {
    private int memberID;
    private MemberModel member;

    @Override
    public String execute() throws Exception {
        Object a = ActionContext.getContext().getParameters();
        member = new MemberService(MySQLConnection.getConnection()).findById(memberID);
        return member == null ? ERROR : SUCCESS;
    }

    public MemberModel getMember() {
        return member;
    }

    public void setMember(MemberModel member) {
        this.member = member;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
}
