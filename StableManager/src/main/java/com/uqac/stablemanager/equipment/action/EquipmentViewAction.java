package com.uqac.stablemanager.equipment.action;

import com.uqac.stablemanager.equipment.model.EquipmentModel;
import com.uqac.stablemanager.equipment.service.EquipmentService;
import com.uqac.stablemanager.horse.model.HorseModel;
import com.uqac.stablemanager.horse.service.HorseService;
import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.member.service.IMemberService;
import com.uqac.stablemanager.utils.AuthenticatedAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

public class EquipmentViewAction extends AuthenticatedAction {
    private static final long serialVersionUID = 1L;


    @Autowired EquipmentService equipmentService;
    @Autowired IMemberService memberService;

    private EquipmentModel equipment;
    private MemberModel owner;
    private int equipmentID;

    @Override
    public String execute() throws Exception {
        equipment = equipmentService.findById(equipmentID);
        owner = memberService.findById(equipment.getMemberId());
        return (equipment == null || owner == null) ? ERROR : SUCCESS;
    }

    public EquipmentModel getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentModel equipment) {
        this.equipment = equipment;
    }

    public MemberModel getOwner() {
        return owner;
    }

    public void setOwner(MemberModel owner) {
        this.owner = owner;
    }

    public int getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
    }


}
