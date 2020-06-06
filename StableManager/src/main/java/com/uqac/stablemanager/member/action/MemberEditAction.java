package com.uqac.stablemanager.member.action;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.IMemberService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberEditAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired private SimpleDateFormat dateFormat;
    @Autowired private IMemberService memberService;

    private int memberID;
    private MemberModel member;
    private String newPassword;

    @PreAuthorize("@controlBasedService.hasAccess('WRITE_ALL_PROFILES')")
    public String view() throws Exception {
        member = memberService.findById(memberID);
        return SUCCESS;
    }

    @PreAuthorize("@controlBasedService.hasAccess('WRITE_ALL_PROFILES')")
    public String performUpdate() throws Exception {
        member.setId(memberID);
        boolean success = memberService.update(member);
        if (!success) {
            addActionError("Impossible de mettre à jour le profil");
        }
        return success ? SUCCESS : ERROR;
    }

    @PreAuthorize("@controlBasedService.hasAccess('WRITE_ALL_PROFILES')")
    public String performUpdatePassword() throws Exception {
        boolean success = memberService.changePassword(memberID, newPassword);
        return success ? SUCCESS : ERROR;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public MemberModel getMember() {
        return member;
    }

    public void setMember(MemberModel member) {
        this.member = member;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public void setBirthDate(String plainDate) {
        try {
            if (member == null) member = new MemberModel();
            member.setBirthDate(dateFormat.parse(plainDate));
            System.err.println("ee");
        } catch (ParseException e) {
            System.err.println(e);
//            addActionError("Invalid date format");
        }
    }

    public String getBirthDate() {
        Date birthDate = member.getBirthDate();
        return  birthDate == null ? "" : dateFormat.format(birthDate);
    }
}
