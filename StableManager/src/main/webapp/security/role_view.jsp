<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <t:pagedescription title="Sécurité > Rôle > ${roleName}"  />

    <s:if test="usersWithThisRole.isEmpty()">
        <p>
            <a href="<s:url action="role/perform_delete/%{role.name}" namespace="/security" />">Supprimer</a>
        </p>
    </s:if><s:else>
        Ce rôle ne peux pas être supprimé, des membres y sont encore associés
    </s:else>
    <p>
        <a href="<s:url action="role/edition"><s:param name="roleName" value="roleName"/></s:url>">Modifier</a>
    </p>



    <h2>${role.name}</h2>
    <p>${role.description}</p>

    <h3>Privilèges</h3>
    <s:iterator value="role.rights" var="permission">
        <p>${permission.name}</p>
        <p>${permission.description}</p>
    </s:iterator>

    <h3>Membres</h3>
    <t:memberlist members="${usersWithThisRole}" />

</t:basepage>