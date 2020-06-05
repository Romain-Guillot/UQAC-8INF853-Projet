<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:basepage pageTitle="StableManager">
    <jsp:attribute name="pageHeader">
        <t:pagedescription title="Matériel > Edition > ${equipment.id}" />
    </jsp:attribute>


    <jsp:body>
        <h2>Information générales</h2>
        <s:form action="perform_edit/%{equipment.id}" namespace="/equipment">
            <s:textfield name="equipment.type" label="Type" />
            <s:textfield name="equipment.model" label="Modèle" />
            <s:textfield name="equipment.price" label="Prix" />
            <s:textfield name="equipment.memberId" label="ID du Membre" />
            <s:submit/>
        </s:form>
    </jsp:body>
</t:basepage>