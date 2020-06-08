package com.uqac.stablemanager.horse.action;

import com.uqac.stablemanager.horse.model.HorseModel;
import com.uqac.stablemanager.horse.service.HorseService;
import com.uqac.stablemanager.horse.service.IHorseService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;


import java.util.List;

public class HorseListViewAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired IHorseService horseService;
    private List<HorseModel> horses;

    @Override
    public String execute() throws Exception {
        horses = horseService.list();
        return SUCCESS;
    }

    public List<HorseModel> getHorses() {
        return horses;
    }
}
