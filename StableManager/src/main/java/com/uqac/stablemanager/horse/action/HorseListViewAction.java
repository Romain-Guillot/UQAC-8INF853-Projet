package com.uqac.stablemanager.horse.action;

import com.uqac.stablemanager.horse.model.HorseModel;
import com.uqac.stablemanager.horse.service.HorseService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;


import java.util.List;

@PreAuthorize("hasAuthority('READ_ALL_PROFILES')")
public class HorseListViewAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;


    @Autowired HorseService horseService;

    private List<HorseModel> horses;

    @Override
    public String execute() {
        horses = horseService.list();
        return SUCCESS;
    }

    public List<HorseModel> getHorses() {
        return horses;
    }

}
