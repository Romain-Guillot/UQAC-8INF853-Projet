<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <t:pagedescription title="Horse > Liste" ></t:pagedescription>
    <sec:authorize access="hasAuthority('WRITE_ALL_PROFILES')">
        PERMISSION PRIVILEGE ?? :
        <%--        <p><a href="<s:url action='edit/%{member.id}' namespace="/member"/>">Modifier</a></p>--%>
        <p><a href="<s:url action='perform_delete/%{horse.id}' namespace="/horse"/>">Supprimer</a></p>
    </sec:authorize>

    Name: <s:property value="horse.name"/><br>
    Birth date: <s:property value="horse.birthDate"/><br>
</t:basepage>