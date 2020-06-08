<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <t:pagedescription title="Chevaux > ${horse.id}" />
    <sec:authorize access="hasAuthority('WRITE_ALL_PROFILES')">
        <a href="<s:url action='edit/%{horse.id}' namespace="/horse"/>" class="waves-effect waves-light btn">Modifier</a>
        <a href="<s:url action='perform_delete/%{horse.id}' namespace="/horse"/>" class="waves-effect waves-light btn btn-error">Supprimer</a>
    </sec:authorize>
    <br>
    Name: <s:property value="horse.name"/><br>
    Birth date: <s:property value="horse.birthDate"/><br>
    Propriétaire: <a href="<s:url action='view/%{horse.owner.id}' namespace="/member"/>">${horse.owner}</a><br>
</t:basepage>