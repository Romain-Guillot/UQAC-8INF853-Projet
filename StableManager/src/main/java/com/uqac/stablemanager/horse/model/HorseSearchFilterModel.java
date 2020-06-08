package com.uqac.stablemanager.horse.model;

public class HorseSearchFilterModel {
    private String horseName;
    private String owner;
    private Boolean linkedWithBookings;


    public String getHorseName() {
        return horseName;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setLinkedWithBookings(Boolean linkedWithBookings) {
        this.linkedWithBookings = linkedWithBookings;
    }

    public Boolean getLinkedWithBookings() {
        return linkedWithBookings;
    }
}
