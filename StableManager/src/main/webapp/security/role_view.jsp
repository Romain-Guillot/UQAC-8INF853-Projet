<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">
    <jsp:attribute name="pageHeader">
        <t:pagedescription title="Sécurité > Rôle > ${roleName}"  />
    </jsp:attribute>


    <jsp:body>
        <a href="<s:url action="role/edition"><s:param name="roleName" value="roleName"/></s:url>" class="waves-effect waves-light btn">
            Modifier
        </a>
        <s:if test="usersWithThisRole.isEmpty()">
            <a href="<s:url action="role/perform_delete/%{role.name}" namespace="/security" />" class="waves-effect waves-light btn btn-error">
                Supprimer
            </a>
        </s:if><s:else>
            <span>Ce rôle ne peux pas être supprimé, des membres y sont encore associés<span>
        </s:else>


        <p>${role.description}</p>

        <h2>Privilèges</h2>
        <s:if test="%{role.rights.isEmpty()}">
            <p class="empty-indicator">Aucun privilège</p>
        </s:if>
        <s:else>
            <ul class="collection">
                <li class="collection-item collection-header row collection-item-content">
                    <span class="col s3">Nom</span>
                    <span class="col s9">Description</span>
                </li>

                <s:iterator value="role.rights" var="permission">
                <li class="row collection-item">
                    <p class="col s3">${permission.name}</p>
                    <p class="col s9">${permission.description}</p>
                </li>
                </s:iterator>
            </ul>
        </s:else>

        <h2>Membres</h2>
        <t:memberlist members="${usersWithThisRole}" />
    </jsp:body>


</t:basepage>