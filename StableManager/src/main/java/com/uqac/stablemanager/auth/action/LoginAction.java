package com.uqac.stablemanager.auth.action;

import com.opensymphony.xwork2.ActionSupport;
import com.uqac.stablemanager.auth.model.CredentialModel;

public class LoginAction extends ActionSupport {

    CredentialModel credential;

    @Override
    public String execute() throws Exception {
        credential = new CredentialModel();
        return SUCCESS;
    }
}
