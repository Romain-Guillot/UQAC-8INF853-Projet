<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <t:pagedescription title="Sécurité > Rôle > ${role.name}"  />

    <p>
        <s:set value="role.name" var="roleName"/>
        <a href="<s:url action="role/perform_delete/%{#roleName}" namespace="/security" />">Supprimer</a>
    </p>

    ${role.name}


    <s:iterator value="role.rights">
        <p>${name}</p>
    </s:iterator>


</t:basepage>