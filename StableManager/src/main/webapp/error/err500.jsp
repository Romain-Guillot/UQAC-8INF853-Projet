<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

<jsp:attribute name="pageHeader">
        <t:pagedescription title="Erreur • 500"/>
    </jsp:attribute>

<jsp:body>
    <img src="/StableManager/assets/img/error.png" class="error-img">
    <h1>Une erreur serveur est survenue.</h1>
</jsp:body>
</t:basepage>
