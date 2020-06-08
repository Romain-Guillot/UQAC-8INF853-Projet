package com.uqac.stablemanager.equipment.action;

import com.uqac.stablemanager.equipment.service.EquipmentService;
import com.uqac.stablemanager.horse.service.HorseService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

public class EquipmentDeleteAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;


    @Autowired EquipmentService equipmentService;

    private int equipmentID;

    @Override
    public String execute() {
        boolean success = equipmentService.delete(equipmentID);
        return success == false ? ERROR : SUCCESS;
    }

    public int getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
    }


}
