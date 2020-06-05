package com.uqac.stablemanager.equipment.action;

import com.uqac.stablemanager.equipment.model.EquipmentModel;
import com.uqac.stablemanager.equipment.service.EquipmentService;
import com.uqac.stablemanager.horse.model.HorseModel;
import com.uqac.stablemanager.horse.service.HorseService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasAuthority('READ_ALL_PROFILES')")
public class EquipmentViewAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;


    @Autowired EquipmentService equipmentService;

    private EquipmentModel equipment;
    private int equipmentID;

    @Override
    public String execute() {
        equipment = equipmentService.findById(equipmentID);
        return equipment == null ? ERROR : SUCCESS;
    }

    public EquipmentModel getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentModel equipment) {
        this.equipment = equipment;
    }

    public int getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
    }


}
