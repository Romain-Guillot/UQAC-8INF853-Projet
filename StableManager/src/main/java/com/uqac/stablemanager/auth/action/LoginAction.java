package com.uqac.stablemanager.auth.action;

import com.opensymphony.xwork2.ActionSupport;
import com.uqac.stablemanager.auth.model.CredentialsModel;
import com.uqac.stablemanager.auth.service.AuthenticationService;
import com.uqac.stablemanager.utils.MySQLConnection;

public class LoginAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private CredentialsModel credential;

    @Override
    public String execute() {
        boolean isAuthenticated = new AuthenticationService(MySQLConnection.getConnection()).login(credential);
        if (!isAuthenticated)
            addActionError("Impossible de vous connecter avec ces informations");
        return isAuthenticated ? SUCCESS : ERROR;
    }

    public CredentialsModel getCredential() {
        return credential;
    }

    public void setCredential(CredentialsModel credential) {
        this.credential = credential;
    }
}
