package com.uqac.stablemanager.utils;

import com.opensymphony.xwork2.ActionSupport;
import com.uqac.stablemanager.auth.service.IAuthenticationService;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.SQLMemberService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Classe abstraite qui étend [ActionSupport] et qui fournit en plus l'accès à l'utilisateur
 * présentement connecté.
 */
public class AuthenticatedAction extends ActionSupport implements SessionAware {

    @Autowired
    SQLMemberService SQLMemberService;

    protected String ERROR_404 = "error_404";
    protected String ERROR_403 = "error_403";
    protected String ERROR_500 = "error_500";

    private MemberModel member;
    @Autowired
    private IAuthenticationService authenticationService;


    public MemberModel getUser() throws Exception {
        int userID = member.getId();
        return SQLMemberService.findById(userID); // TODO: voir pour juste renvoyé [member], problème d'update des données?
    }

    @Override
    public void setSession(Map<String, Object> map) {
        try {
            member = authenticationService.getConnectedMember(map);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
