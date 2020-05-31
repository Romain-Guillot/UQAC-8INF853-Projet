<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:basepage pageTitle="StableManager">
    <jsp:attribute name="pageHeader">
        <t:pagedescription title="Chevaux > Edition > ${horse.id}" />
    </jsp:attribute>


    <jsp:body>
        <h2>Information générales</h2>
        <s:form action="perform_edit/%{horse.id}" namespace="/horse">
            <s:textfield name="horse.name" label="Nom" />
            <s:textfield name="horse.birthDate" label="Date de naissance" />
            <s:textfield name="horse.memberId" label="ID du Membre" />
            <s:submit/>
        </s:form>
    </jsp:body>
</t:basepage>