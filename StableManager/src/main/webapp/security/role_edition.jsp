<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <t:pagedescription title="Sécurité > Rôle > Edition"  />

    ${roleName}

    <s:form action="perform_edition" method="post">
        <s:hidden name="roleName" value="%{roleName}"/>

        <s:textfield key="role.name" label="Nom"/>
        <s:textfield key="role.description" label="Nom"/>

        <s:select
                label="Privilèges"
                list="permissions"
                listKey="name"
                listValue="name"
                multiple="true"
                key="selectedPermissions"
                value="%{role.rights.{name}}"
        />

        <s:submit />
    </s:form>

</t:basepage>