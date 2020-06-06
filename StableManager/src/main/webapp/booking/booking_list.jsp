<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">
    <jsp:attribute name="pageHeader">
        <t:pagedescription title="Locations > Liste" />
    </jsp:attribute>


    <jsp:body>
        <t:bookinglist bookings="${bookings}"/>
    </jsp:body>
</t:basepage>