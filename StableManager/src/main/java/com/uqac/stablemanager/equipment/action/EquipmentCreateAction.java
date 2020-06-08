package com.uqac.stablemanager.equipment.action;

import com.uqac.stablemanager.equipment.model.EquipmentModel;
import com.uqac.stablemanager.equipment.service.EquipmentService;
import com.uqac.stablemanager.horse.model.HorseModel;
import com.uqac.stablemanager.horse.service.HorseService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

public class EquipmentCreateAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;


    @Autowired EquipmentService equipmentService;
    private EquipmentModel equipment;

    public String perform() {
        boolean success = false;
        if (equipment != null)
            success = equipmentService.create(equipment);
        return success ? SUCCESS : ERROR;
    }

    public EquipmentModel getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentModel equipment) {
        this.equipment = equipment;
    }


}
