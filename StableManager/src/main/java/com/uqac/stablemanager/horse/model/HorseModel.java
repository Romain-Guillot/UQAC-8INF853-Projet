package com.uqac.stablemanager.horse.model;

import com.uqac.stablemanager.member.model.MemberModel;

import java.util.Date;

public class HorseModel {
    private int id;
    private String name;
    private Date birthDate;
    private MemberModel owner;

    public HorseModel() { }

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

    public MemberModel getOwner() {
        return owner;
    }

    public void setOwner(MemberModel owner) {
        this.owner = owner;
    }
}
