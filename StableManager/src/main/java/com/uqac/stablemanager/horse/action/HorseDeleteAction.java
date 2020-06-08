package com.uqac.stablemanager.horse.action;

import com.uqac.stablemanager.horse.service.IHorseService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;

public class HorseDeleteAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired IHorseService horseService;
    private int horseID;

    @Override
    public String execute() throws Exception {
        horseService.delete(horseID);
        return SUCCESS;
    }

    public int getHorseID() {
        return horseID;
    }

    public void setHorseID(int horseID) {
        this.horseID = horseID;
    }
}
