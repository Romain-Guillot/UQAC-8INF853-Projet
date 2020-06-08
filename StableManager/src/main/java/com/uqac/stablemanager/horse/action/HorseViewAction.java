package com.uqac.stablemanager.horse.action;

import com.uqac.stablemanager.horse.model.HorseModel;
import com.uqac.stablemanager.horse.service.HorseService;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.IMemberService;
import com.uqac.stablemanager.member.service.MemberControlBasedService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@PreAuthorize("hasAuthority('READ_ALL_PROFILES')")
public class HorseViewAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;


    @Autowired HorseService horseService;
    @Autowired IMemberService memberService;

    private HorseModel horse;
    private MemberModel owner;
    private int horseID;

    @Override
    public String execute() throws Exception {
        horse = horseService.findById(horseID);
        owner = memberService.findById(horse.getMemberId());
        return (horse == null || owner == null) ? ERROR : SUCCESS;
    }

    public HorseModel getHorse() {
        return horse;
    }

    public void setHorse(HorseModel horse) {
        this.horse = horse;
    }

    public MemberModel getOwner() {
        return owner;
    }

    public void setOwner(MemberModel owner) {
        this.owner = owner;
    }

    public int getHorseID() {
        return horseID;
    }

    public void setHorseID(int horseID) {
        this.horseID = horseID;
    }


}
