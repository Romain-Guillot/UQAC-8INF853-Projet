<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">
    <jsp:attribute name="pageHeader">
        <t:pagedescription title="Locations > Liste" />
    </jsp:attribute>


    <jsp:body>
        <s:if test="bookings.isEmpty">
            <p class="empty-indicator">Aucune locations</p>
        </s:if>
        <s:else>
            <ul class="collection">
                <li class="collection-item collection-header row collection-item-content">
                    <span class="col s3">#ID</span>
                    <span class="col s3">Membre</span>
                    <span class="col s3">Ressource</span>
                    <span class="col s3">Plage horaire</span>
                </li>
                <s:iterator value="bookings" var="booking">
                    <li class="collection-item">
                        <a href="<s:url action='view/%{id}"' namespace="/booking"/>" class="row collection-item-content">
                            <span class="col s3">${booking.id}</span>
                            <span class="col s3">${booking.member}</span>
                            <span class="col s3">${booking.resource}</span>
                            <span class="col s3"><t:timeslot timeslot="${booking.timeSlot}"/></span>
                        </a>
                    </li>
                </s:iterator>
            </ul>
        </s:else>
    </jsp:body>
</t:basepage>