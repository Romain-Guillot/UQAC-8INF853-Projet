package com.uqac.stablemanager.auth.model;


public class CredentialModel {
    
    private String email;
    private String password;
    
    public CredentialModel() { }

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
