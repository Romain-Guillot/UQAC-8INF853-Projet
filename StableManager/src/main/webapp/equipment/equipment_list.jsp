<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <t:pagedescription title="Matériel > Liste" ></t:pagedescription>
    <sec:authorize access="hasAuthority('WRITE_ALL_PROFILES')">
        <a href="<s:url action='create' namespace="/equipment"/>" class="waves-effect waves-light btn">Ajouter un equipement</a>
    </sec:authorize>
    <t:equipmentlist equipments="${equipments}"  />

</t:basepage>