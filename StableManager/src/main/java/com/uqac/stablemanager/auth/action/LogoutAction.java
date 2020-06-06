package com.uqac.stablemanager.auth.action;

import com.opensymphony.xwork2.ActionSupport;
import com.uqac.stablemanager.auth.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Action pour gérer la deconnexion d'un utilisateur sur le site
 *
 * Le processus de déconnexion est assuré par le service [IAuthenticationService]
 */
public class LogoutAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Autowired private IAuthenticationService authenticationService;

    @Override
    public String execute() throws Exception {
        authenticationService.logout();
        return SUCCESS;
    }
}
