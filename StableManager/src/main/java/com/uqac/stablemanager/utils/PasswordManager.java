package com.uqac.stablemanager.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * Class utilitaire pour gérer les mot de passe chiffrés avec l'algorithme BCRYPT.
 *
 * En particulier, elle possède deux fonctions :
 *  - vérification si un mot de passe en clair correspond à un hash
 *  - chiffrement d'un mot de passe
 */
public class PasswordManager {
    private final int logRounds;

    public PasswordManager(int logRounds) {
        this.logRounds = logRounds;
    }

    /**
     * Chiffre un mot de passe avec l'algoritgme BCRYPT avec un certain nombre de round
     * défini lors de la création de l'instance.
     *
     * @param plainPassword le mot de passe à chiffrer
     * @return le mot de passe chiffré
     */
    public String hash(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(logRounds));
    }

    /**
     * Vérifie si un mot de passe en clair correspond à un hash
     *
     * @param plainPassword le mot de passe en clair
     * @param hashPassword le hash du mot de passe
     * @return vrai si les mots de passe correspondent
     */
    public boolean check(String plainPassword, String hashPassword) {
        return BCrypt.checkpw(plainPassword, hashPassword);
    }

    /**
     * @return le nombre de rounds utilisé pour chiffrer les mots de passe
     */
    public int getLogRounds() {
        return logRounds;
    }
}
