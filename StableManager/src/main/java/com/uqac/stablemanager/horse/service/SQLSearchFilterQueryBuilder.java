package com.uqac.stablemanager.horse.service;

import com.uqac.stablemanager.horse.model.HorseSearchFilterModel;

/**
 * Class pour abstraire l'immondise qu'est de créer notre requête de recherche à partir
 * d'un object HorseSearchFilterModel
 */
public class SQLSearchFilterQueryBuilder {

    public String build(HorseSearchFilterModel filter) {
        String query = "SELECT * FROM Horse H";
        if (filter == null)
            return query;
        String ownerFilter = filter.getOwner();
        Boolean linkedWithBooking = filter.getLinkedWithBookings();
        if (linkedWithBooking != null) {
            if (linkedWithBooking) {
                query += " INNER JOIN Booking B ON H.id = B.resource_id";
            } else {
                query += " LEFT JOIN Booking B ON H.id = B.resource_id"; // the where clause is added later
            }
        }
        String horseNameFilter = filter.getHorseName();
        boolean whereClauseStarted = false;
        if (ownerFilter != null && !ownerFilter.isEmpty()) {
            query += (" WHERE H.profile_member_id = '" + filter.getOwner()) + "'";
            whereClauseStarted = true;
        }
        if (horseNameFilter != null && !horseNameFilter.isEmpty()) {
            query += (whereClauseStarted ? " AND" : " WHERE");
            query += (" H.name = '" + filter.getHorseName()) + "'";
            whereClauseStarted = true;
        }
        if (linkedWithBooking != null && !linkedWithBooking) { // we add the Left join where clause
            query += (whereClauseStarted ? " AND" : " WHERE");
            query += " B.booking_id IS NULL";
        }
        return query;
    }
}
