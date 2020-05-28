<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <t:pagedescription title="Employés > Profile > ${user.id}" />

    First name: <s:property value="member.firstName"/><br>
    Last name: <s:property value="member.lastName"/><br>
    Email: <s:property value="member.email"/><br>
    Birth date: <s:property value="member.birthDate"/><br>
    Postal address: <s:property value="member.postalAddress"/>

</t:basepage>