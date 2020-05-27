package com.uqac.stablemanager.auth.action;

import com.opensymphony.xwork2.ActionSupport;
import com.uqac.stablemanager.auth.service.AuthenticationService;
import com.uqac.stablemanager.utils.MySQLConnection;

public class LogoutAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        System.err.println("LOGOUT ACTION");
        new AuthenticationService(MySQLConnection.getConnection()).logout();
        return SUCCESS;
    }
}
