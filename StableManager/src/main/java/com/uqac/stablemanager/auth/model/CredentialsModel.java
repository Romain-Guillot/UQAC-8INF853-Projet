package com.uqac.stablemanager.auth.model;

/**
 * Modèle représentant les données d'identification d'un utiliseur :
 *  - email
 *  - mot de passe
 */
public class CredentialsModel {
    private String email;
    private String password;
    
    public CredentialsModel() { }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
