package com.uqac.stablemanager.horse.action;

import com.uqac.stablemanager.horse.model.HorseModel;
import com.uqac.stablemanager.horse.service.HorseService;
import com.uqac.stablemanager.horse.service.IHorseService;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.IMemberService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

public class HorseEditAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired IHorseService horseService;
    @Autowired IMemberService memberService;
    private HorseModel horse;
    private int horseID;

    public String view() throws Exception {
        horse = horseService.findById(horseID);
        return SUCCESS;
    }

    public String performUpdate() throws Exception {
        horseService.update(horse);
        return SUCCESS;
    }

    public HorseModel getHorse() {
        return horse;
    }

    public void setHorse(HorseModel horse) {
        this.horse = horse;
    }

    public void setOwner(int ownerID) throws Exception {
        MemberModel newOwner = memberService.findById(ownerID);
        horse.setOwner(newOwner);
    }
    public int getOwner() {
        return horse.getOwner().getId();
    }

    public int getHorseID() {
        return horseID;
    }

    public void setHorseID(int horseID) {
        this.horseID = horseID;
    }
}
