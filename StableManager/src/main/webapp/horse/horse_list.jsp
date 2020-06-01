<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <t:pagedescription title="Chevaux > Liste" ></t:pagedescription>
    <sec:authorize access="hasAuthority('WRITE_ALL_PROFILES')">
        <a href="<s:url action='create' namespace="/horse"/>" class="waves-effect waves-light btn">Ajouter un cheval</a>
    </sec:authorize>
    <t:horselist horses="${horses}"  />

</t:basepage>