<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <t:pagedescription title="Matériel > ${equipment.id}" ></t:pagedescription>
    <sec:authorize access="hasAuthority('WRITE_ALL_PROFILES')">
        <a href="<s:url action='edit/%{equipment.id}' namespace="/equipment"/>" class="waves-effect waves-light btn">Modifier</a>
        <a href="<s:url action='perform_delete/%{equipment.id}' namespace="/equipment"/>" class="waves-effect waves-light btn btn-error">Supprimer</a>
    </sec:authorize>
    <br>
    Type: <s:property value="equipment.type"/><br>
    Modèle: <s:property value="equipment.model"/><br>
    Prix: <s:property value="equipment.price"/> €/heure<br>
</t:basepage>