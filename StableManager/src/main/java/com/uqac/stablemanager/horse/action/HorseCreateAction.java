package com.uqac.stablemanager.horse.action;

import com.uqac.stablemanager.horse.model.HorseModel;
import com.uqac.stablemanager.horse.service.HorseService;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasAuthority('WRITE_ALL_PROFILES')")
public class HorseCreateAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;


    @Autowired HorseService horseService;
    private HorseModel horse;

    public String perform() {
        boolean success = false;
        if (horse != null)
            success = horseService.create(horse);
        return success ? SUCCESS : ERROR;
    }

    public HorseModel getHorse() {
        return horse;
    }

    public void setHorse(HorseModel horse) {
        this.horse = horse;
    }


}
