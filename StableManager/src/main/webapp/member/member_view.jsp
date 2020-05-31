<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<t:basepage pageTitle="StableManager">

    <t:pagedescription title="Employés > ${member.id}" />

    <sec:authorize access="hasAuthority('WRITE_ALL_PROFILES')">
        PERMISSION PRIVILEGE ?? :
        <p><a href="<s:url action='edit/%{member.id}' namespace="/member"/>">Modifier</a></p>
        <p><a href="<s:url action='perform_delete/%{member.id}' namespace="/member"/>">Supprimer</a></p>
    </sec:authorize>


    <s:if test="user.id == member.id">
        <p><a href="<s:url action='edit/%{member.id}' namespace="/member"/>">Modifier</a></p>
        <p><a href="<s:url action='perform_delete/%{member.id}' namespace="/member"/>">Supprimer</a></p>
    </s:if>

    First name: <s:property value="member.firstName"/><br>
    Last name: <s:property value="member.lastName"/><br>
    Email: <s:property value="member.email"/><br>
    Birth date: <s:property value="member.birthDate"/><br>
    Postal address: <s:property value="member.postalAddress"/>

</t:basepage>