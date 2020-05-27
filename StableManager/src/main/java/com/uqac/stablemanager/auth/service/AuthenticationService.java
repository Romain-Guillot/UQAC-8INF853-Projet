package com.uqac.stablemanager.auth.service;

import com.uqac.stablemanager.auth.model.CredentialsModel;
import com.uqac.stablemanager.member.model.MemberModel;
import org.apache.struts2.ServletActionContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import java.sql.Connection;


public class AuthenticationService {

    private final Connection connection;

    public AuthenticationService(Connection connection) {
        this.connection = connection;
    }

    public void login(CredentialsModel credentials) {
        UserDetails user = new MemberModel();
        Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    public void logout() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(ServletActionContext.getRequest(), ServletActionContext.getResponse(), auth);
        }
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}
