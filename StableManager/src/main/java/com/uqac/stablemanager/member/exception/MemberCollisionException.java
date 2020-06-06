package com.uqac.stablemanager.member.exception;

public class MemberCollisionException  extends Exception {
    @Override
    public String toString() {
        return "Un utilisateur avec le même email existe déjà";
    }
}
