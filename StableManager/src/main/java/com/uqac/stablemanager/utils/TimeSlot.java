package com.uqac.stablemanager.utils;

import java.util.Date;

/**
 * Plage horaire avec une date de début et de fin
 */
public class TimeSlot {
    private Date begin;
    private Date end;

    public TimeSlot(Date begin, Date end) {
        this.begin = begin;
        this.end = end;
    }

    public Date getBegin() {
        return begin;
    }

    public Date getEnd() {
        return end;
    }
}
