package com.uqac.stablemanager.member.action;

import com.uqac.stablemanager.member.exception.MemberCollisionException;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.IMemberService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

public class MemberCreateAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired IMemberService memberService;
    private MemberModel member;
    private String passwordConfirmation;

    @PreAuthorize("@controlBasedService.hasAccess('WRITE_ALL_PROFILES')")
    public String perform() throws Exception {
        try {
            memberService.create(member);
            return SUCCESS;
        } catch (MemberCollisionException exception) {
            addActionError(exception.toString());
            return ERROR;
        }
    }

    @Override
    public void validate() {
        if (member.getEmail() == null || member.getEmail().isEmpty()) {
            addFieldError("member.email", "Veuillez renseigner un email");
        }
        if (member.getPassword() == null || member.getPassword().isEmpty()) {
            addFieldError("member.password", "Veuillez renseigner un email");
        }
        if (passwordConfirmation != null && !passwordConfirmation.equals(member.getPassword())) {
            addFieldError("passwordConfirmation", "Les mots de passe de correspondent pas");
        }
    }

    public MemberModel getMember() {
        return member;
    }

    public void setMember(MemberModel member) {
        this.member = member;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
}
