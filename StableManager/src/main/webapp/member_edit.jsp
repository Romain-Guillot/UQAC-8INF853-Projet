<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <t:pagedescription title="Employés > Profile > Edition > ${user.id}" />

    <s:set value="member.id" var="memberID"/>

    <h2>Information générales</h2>
    <s:form action="perform_edit/%{#memberID}" namespace="/member">
        <s:textfield name="member.firstName" label="Prénom"/>
        <s:textfield name="member.lastName" label="Nom" />
        <s:textfield name="member.email" label="Email" />
        <s:textfield name="member.postalAddress" label="Adresse postale" />
        <s:textfield name="member.birthDate" label="Date de naissance" />
        <s:submit/>
    </s:form>

    <h2>Mot de passe</h2>
    <s:form action="perform_changepassword/%{#memberID}" namespace="/member">
        <s:textfield name="newPassword" label="Nouveau mot de passe"/>
        <s:submit/>
    </s:form>
</t:basepage>