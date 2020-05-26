package com.uqac.stablemanager.auth.action;

import com.opensymphony.xwork2.ActionSupport;
import com.uqac.stablemanager.auth.model.CredentialModel;
import com.uqac.stablemanager.auth.service.AuthenticationService;

public class LoginAction extends ActionSupport {

    CredentialModel credential;

    @Override
    public String execute() throws Exception {
        System.err.println("LOGIN ACTION");
        credential = new CredentialModel();
        new AuthenticationService().login("", "");
        return SUCCESS;
    }
}
