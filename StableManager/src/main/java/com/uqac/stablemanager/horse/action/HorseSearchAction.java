package com.uqac.stablemanager.horse.action;

import com.uqac.stablemanager.horse.model.HorseModel;
import com.uqac.stablemanager.horse.model.HorseSearchFilterModel;
import com.uqac.stablemanager.horse.service.HorseService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HorseSearchAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;

    @Autowired private HorseService horseService;
    private List<HorseModel> horses;
    private HorseSearchFilterModel horseFilter;

    @Override
    public String execute() throws Exception {
        horses = horseService.listWithFilter(horseFilter);
        return SUCCESS;
    }

    public HorseSearchFilterModel getHorseFilter() {
        return horseFilter;
    }

    public void setHorseFilter(HorseSearchFilterModel horseFilter) {
        this.horseFilter = horseFilter;
    }

    public List<HorseModel> getHorses() {
        return horses;
    }

    public void setHorses(List<HorseModel> horses) {
        this.horses = horses;
    }

    public void setLinkedWithBookings(String value) {
        switch (value) {
            case "1": // yes
                horseFilter.setLinkedWithBookings(true);
                break;
            case "2": // no
                horseFilter.setLinkedWithBookings(false);
                break;
            case "3": // indifferent
            default:
                horseFilter.setLinkedWithBookings(null);
        }
    }

    public String getLinkedWithBookings() {
        return horseFilter.getLinkedWithBookings() == null ? "3" : (horseFilter.getLinkedWithBookings() ? "1" : "2");
    }
}
