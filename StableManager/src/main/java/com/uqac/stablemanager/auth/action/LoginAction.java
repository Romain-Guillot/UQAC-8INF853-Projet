package com.uqac.stablemanager.auth.action;

import com.opensymphony.xwork2.ActionSupport;
import com.uqac.stablemanager.auth.model.CredentialsModel;
import com.uqac.stablemanager.auth.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Action pour gérer la connexion d'un utilisateur sur le site
 *
 * Les informations de connexion (credentials) sont stockés dans un modèle [CredentialsModel]
 * Le processus d'authentification est assuré par le service [IAuthenticationService]
 */
public class LoginAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Autowired private IAuthenticationService authenticationService;
    private CredentialsModel credential;

    @Override
    public String execute() {
        boolean isAuthenticated = authenticationService.login(credential);
        if (!isAuthenticated) {
            addActionError("Impossible de vous connecter avec ces informations");
        }
        return isAuthenticated ? SUCCESS : ERROR;
    }

    public CredentialsModel getCredential() {
        return credential;
    }

    public void setCredential(CredentialsModel credential) {
        this.credential = credential;
    }
}
