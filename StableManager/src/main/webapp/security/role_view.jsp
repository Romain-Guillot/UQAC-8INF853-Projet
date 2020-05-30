<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <t:pagedescription title="Sécurité > Rôle > ${role.name}"  />

    <s:if test="usersWithThisRole.isEmpty()">
        <p>
            <s:set value="role.name" var="roleName"/>
            <a href="<s:url action="role/perform_delete/%{#roleName}" namespace="/security" />">Supprimer</a>
        </p>
    </s:if><s:else>
        Ce rôle ne peux pas être supprimé, des membres y sont encore associés
    </s:else>


    <h2>${role.name}</h2>

    <h3>Privilèges</h3>
    <s:iterator value="role.rights">
        <p>${name}</p>
    </s:iterator>

    <h3>Membres</h3>
    <t:memberlist members="${usersWithThisRole}" />

</t:basepage>