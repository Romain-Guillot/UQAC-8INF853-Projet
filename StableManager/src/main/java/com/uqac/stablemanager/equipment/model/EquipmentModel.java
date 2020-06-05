package com.uqac.stablemanager.equipment.model;

import java.util.Date;

public class EquipmentModel {
    private int id;
    private String model;
    private String type;
    private float price;
    private int memberId;

    public EquipmentModel() { }

    public EquipmentModel(EquipmentModel equipment) {
        id = equipment.id;
        model = equipment.model;
        type = equipment.type;
        price = equipment.price;
        memberId = equipment.memberId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

}
