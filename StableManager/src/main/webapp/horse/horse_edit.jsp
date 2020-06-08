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
            <s:hidden name="horse.id" />
            <s:textfield name="owner" label="Propriétaire" />
            <s:textfield name="horse.name" label="Nom" />
            <s:textfield name="horse.birthDate" label="Date de naissance" />
            <s:submit/>
        </s:form>
    </jsp:body>
</t:basepage>