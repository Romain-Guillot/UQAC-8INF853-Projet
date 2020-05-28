package com.uqac.stablemanager.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordManager {

    public static String hash(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
    }

    public static boolean check(String plainPassword, String hashPassword) {
        return BCrypt.checkpw(plainPassword, hashPassword);
    }
}
