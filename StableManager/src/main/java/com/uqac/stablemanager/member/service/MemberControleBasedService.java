package com.uqac.stablemanager.member.service;

import com.opensymphony.xwork2.ActionContext;
import com.uqac.stablemanager.auth.service.IAuthenticationService;
import com.uqac.stablemanager.member.model.MemberModel;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class MemberControleBasedService {
    @Autowired IAuthenticationService authenticationService;

    public boolean hasAccess(String permission) {
        Map session = (Map) ActionContext.getContext().get("session");
        MemberModel user = authenticationService.getConnectedMember(session);
        HttpServletRequest req = ServletActionContext.getRequest();
        Object resourceOwnerID = req.getAttribute("memberID");
        if (user == null) {
            return false;
        } else {
            if (resourceOwnerID instanceof Integer && ((Integer) resourceOwnerID) == user.getId()) {
                return true;
            }
            for (GrantedAuthority grantedAuth : user.getAuthorities()) {
                if (grantedAuth.getAuthority().equals(permission)) {
                    return true;
                }
            }
            return false;
        }
    }
}
