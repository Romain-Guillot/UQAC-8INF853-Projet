<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">
    <jsp:attribute name="pageHeader">
        <t:pagedescription title="Sécurité > Rôle > Liste"  />
    </jsp:attribute>

    <jsp:body>
        <ul class="collection">
            <li class="collection-item collection-header row collection-item-content">
                <span class="col s3">Nom du rôle</span>
                <span class="col s3">Description</span>
            </li>
            <s:iterator value="roles" var="role">
                <li class="collection-item">
                    <a href="<s:url action='role/view/%{name}' namespace="/security" />" class="row collection-item-content">
                        <span class="col s3">${role.name}</span>
                        <span class="col s9">${role.description}</span>
                    </a>
                </li>
            </s:iterator>
        </ul>
    </jsp:body>
</t:basepage>