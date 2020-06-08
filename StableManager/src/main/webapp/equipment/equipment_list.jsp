<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <jsp:attribute name="pageHeader">
        <t:pagedescription title="Matériel > Liste" />
    </jsp:attribute>

    <jsp:body>
        <a href="<s:url action='create' namespace="/equipment"/>" class="waves-effect waves-light btn">Ajouter un equipement</a>
        <t:equipmentlist equipments="${equipments}"  />
    </jsp:body>
</t:basepage>