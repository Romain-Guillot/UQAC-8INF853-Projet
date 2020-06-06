package com.uqac.stablemanager.auth.service;

import com.uqac.stablemanager.auth.model.CredentialsModel;
import com.uqac.stablemanager.member.model.MemberModel;

import java.util.Map;

/**
 * Interface de gestion de l'authentification, en particulier pour la connexion et la deconnexion
 * des utilisateurs dans le système.
 */
public interface IAuthenticationService {
    /**
     * Procède à l'authentification de l'utilisateur dans le système.
     *
     * @param credentials les informations de connexion.
     * @return true si l'utilisateur est connecté, faux sinon.
     */
    void login(CredentialsModel credentials) throws Exception;

    /**
     * Procède à le déconnexion de l'utilisateur dans le système.
     */
    void logout() throws Exception;

    /**
     * @param sessionObjects les objets actuellement stockés dans la session
     * @return l'utilisateur présentement connecté
     */
    MemberModel getConnectedMember(Map<String, Object> sessionObjects) throws Exception;
}
