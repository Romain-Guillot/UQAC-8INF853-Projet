package com.uqac.stablemanager.utils;

import com.opensymphony.xwork2.ActionSupport;
import com.uqac.stablemanager.member.model.MemberModel;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;

import java.util.Map;

public abstract class AuthenticatedAction extends ActionSupport implements SessionAware {

    private Authentication authentication;

    public MemberModel getUser() {
        return (MemberModel) authentication.getPrincipal();
    }

    @Override
    public void setSession(Map<String, Object> map) {
        authentication = ((SecurityContextImpl) map.get("SPRING_SECURITY_CONTEXT")).getAuthentication();
    }
}
