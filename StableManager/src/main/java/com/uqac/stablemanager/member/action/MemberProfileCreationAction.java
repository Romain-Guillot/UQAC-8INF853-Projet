package com.uqac.stablemanager.member.action;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.MemberService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import com.uqac.stablemanager.utils.MySQLConnection;

public class MemberProfileCreationAction extends AuthenticatedAction {

    private MemberModel member;
    private String passwordConfirmation;

    @Override
    public String execute() {
        boolean success = false;
        if (member != null)
            success = new MemberService(MySQLConnection.getConnection()).create(member);
        return success ? SUCCESS : ERROR;
    }

    @Override
    public void validate() {
        if (member.getEmail() == null) {
            addFieldError("member.email", "Email cannot be empty");
        } else {
            MemberModel memberWithSameEmail = new MemberService(MySQLConnection.getConnection()).findByEmail(member.getEmail());
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
