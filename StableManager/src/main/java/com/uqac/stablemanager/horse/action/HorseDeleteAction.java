package com.uqac.stablemanager.horse.action;

import com.uqac.stablemanager.horse.model.HorseModel;
import com.uqac.stablemanager.horse.service.HorseService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasAuthority('WRITE_ALL_PROFILES')")
public class HorseDeleteAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;


    @Autowired HorseService horseService;

    private int horseID;

    @Override
    public String execute() {
        boolean success = horseService.delete(horseID);
        return success == false ? ERROR : SUCCESS;
    }

    public int getHorseID() {
        return horseID;
    }

    public void setHorseID(int horseID) {
        this.horseID = horseID;
    }


}
