package com.uqac.stablemanager.horse.model;

import java.util.Date;

public class HorseModel {
    private int id;
    private String name;
    private Date birthDate;
    private int memberId;

    public HorseModel() { }

    public HorseModel(HorseModel horse) {
        id = horse.id;
        name = horse.name;
        birthDate = horse.birthDate;
        memberId = horse.memberId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }


}
