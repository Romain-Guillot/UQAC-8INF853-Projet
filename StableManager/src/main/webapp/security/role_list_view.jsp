<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <t:pagedescription title="Sécurité > Rôle > Liste"  />

    <ul>
    <s:iterator value="roles">
        <s:set value="name" var="roleName"/>
        <li><a href="<s:url action='role/view/%{#roleName}' namespace="/security" />">${name}</a></li>
    </s:iterator>
    </ul>


</t:basepage>