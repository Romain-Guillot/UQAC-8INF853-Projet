<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">
    <jsp:attribute name="pageHeader">
        <t:pagedescription title="Sécurité > Rôle > ${roleName}"  />
    </jsp:attribute>


    <jsp:body>
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

        <p>${role.description}</p>

        <h2>Privilèges</h2>
        <ul class="collection">
            <li class="collection-item collection-header row">
                <p class="col s3">Nom</p>
                <p class="col s9">Description</p>
            </li>
            <s:iterator value="role.rights" var="permission">
                <li class="row collection-item">
                    <p class="col s3">${permission.name}</p>
                    <p class="col s9">${permission.description}</p>
                </li>
            </s:iterator>
        </ul>

        <h2>Membres</h2>
        <t:memberlist members="${usersWithThisRole}" />
    </jsp:body>


</t:basepage>