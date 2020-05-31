package com.uqac.stablemanager.horse.action;

import com.uqac.stablemanager.horse.model.HorseModel;
import com.uqac.stablemanager.horse.service.HorseService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasAuthority('READ_ALL_PROFILES')")
public class HorseEditAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;


    @Autowired HorseService horseService;

    private HorseModel horse;
    private int horseID;

    public String view() {
        horse = horseService.findById(horseID);
        return SUCCESS;
    }

    public String performUpdate() {
        horse.setId(horseID);
        boolean success = horseService.update(horse);
        return success ? SUCCESS : ERROR;
    }

    public HorseModel getHorse() {
        return horse;
    }

    public void setHorse(HorseModel horse) {
        this.horse = horse;
    }

    public int getHorseID() {
        return horseID;
    }

    public void setHorseID(int horseID) {
        this.horseID = horseID;
    }


}
