package com.uqac.stablemanager.utils;

import com.opensymphony.xwork2.ActionSupport;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.MemberService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;

import java.util.Map;

public abstract class AuthenticatedAction extends ActionSupport implements SessionAware {

    private Authentication authentication;

    public MemberModel getUser() {
        int userID = ((MemberModel) authentication.getPrincipal()).getId();
        return new MemberService(MySQLConnection.getConnection()).findById(userID);
    }

    @Override
    public void setSession(Map<String, Object> map) {
        authentication = ((SecurityContextImpl) map.get("SPRING_SECURITY_CONTEXT")).getAuthentication();
    }
}
