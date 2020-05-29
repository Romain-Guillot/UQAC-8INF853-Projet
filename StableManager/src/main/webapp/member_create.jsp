<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <t:pagedescription title="Employés > Profile > Création" />

    <h2>Information générales</h2>
    <s:form action="perform_create" namespace="/member">
        <s:textfield name="member.firstName" label="Prénom"/>
        <s:textfield name="member.lastName" label="Nom" />
        <s:textfield name="member.email" label="Email" />
        <s:textfield name="member.postalAddress" label="Adresse postale" />
        <s:textfield name="member.birthDate" label="Date de naissance" />
        <s:submit/>
    </s:form>

</t:basepage>