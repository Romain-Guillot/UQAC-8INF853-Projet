package com.uqac.stablemanager.auth.action;

import com.opensymphony.xwork2.ActionSupport;
import com.uqac.stablemanager.auth.service.AuthenticationService;

public class LogoutAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        System.err.println("LOGOUT ACTION");
        new AuthenticationService().logout();
        return SUCCESS;
    }
}
