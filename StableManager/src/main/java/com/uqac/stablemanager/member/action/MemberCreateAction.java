package com.uqac.stablemanager.member.action;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.IMemberService;
import com.uqac.stablemanager.member.service.MySQLMemberService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

public class MemberCreateAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired
    IMemberService mySQLMemberService;
    private MemberModel member;
    private String passwordConfirmation;

    @PreAuthorize("@controlBasedService.hasAccess('WRITE_ALL_PROFILES')")
    public String perform() throws Exception {
        boolean success = false;
        if (member != null)
            success = mySQLMemberService.create(member);
        return success ? SUCCESS : ERROR;
    }

    @Override
    public void validate() {
        if (member.getEmail() == null) {
            addFieldError("member.email", "Email cannot be empty");
        } else {
            MemberModel memberWithSameEmail = null;
            try {
                memberWithSameEmail = mySQLMemberService.findByEmail(member.getEmail());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            if (memberWithSameEmail != null) {
                addFieldError("member.email", "Email already exists");
            }
        }
        if (member.getPassword().isEmpty()) {
            addFieldError("member.password", "Required");
        }
        if (!passwordConfirmation.equals(member.getPassword())) {
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
