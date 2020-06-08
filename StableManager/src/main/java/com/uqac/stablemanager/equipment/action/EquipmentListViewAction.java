package com.uqac.stablemanager.equipment.action;

import com.uqac.stablemanager.equipment.model.EquipmentModel;
import com.uqac.stablemanager.equipment.service.EquipmentService;
import com.uqac.stablemanager.horse.model.HorseModel;
import com.uqac.stablemanager.horse.service.HorseService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public class EquipmentListViewAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;


    @Autowired EquipmentService equipmentService;

    private List<EquipmentModel> equipments;

    @Override
    public String execute() {
        equipments = equipmentService.list();
        return SUCCESS;
    }

    public List<EquipmentModel> getEquipments() {
        return equipments;
    }
}
