package com.uqac.stablemanager.auth.service;

import com.uqac.stablemanager.auth.model.CredentialsModel;

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
    boolean login(CredentialsModel credentials);

    /**
     * Procède à le déconnexion de l'utilisateur dans le système.
     */
    void logout();
}
