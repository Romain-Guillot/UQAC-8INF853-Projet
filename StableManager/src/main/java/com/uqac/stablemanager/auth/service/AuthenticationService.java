package com.uqac.stablemanager.auth.service;

import com.uqac.stablemanager.member.model.MemberModel;
import org.apache.struts2.ServletActionContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import java.util.Collection;

public class AuthenticationService {

    public void login(String email, String password) {
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
