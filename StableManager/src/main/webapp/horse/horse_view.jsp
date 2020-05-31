<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <t:pagedescription title="Horse > Liste" ></t:pagedescription>

    Name: <s:property value="horse.name"/><br>
    Birth date: <s:property value="horse.birthDate"/><br>
</t:basepage>