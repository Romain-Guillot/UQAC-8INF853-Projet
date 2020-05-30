<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <t:pagedescription title="Employés > Liste" >
        <s:form action="list_applyfilter" namespace="/member">
            <s:select label="Filtrer par rôle"
                      name="selectedRole"
                      list="roles"
                      listKey="name"
                      listValue="name"
                      emptyOption="true"
                      value="%{selectedRole}"
            />
            <s:submit/>
        </s:form>
    </t:pagedescription>

    <t:memberlist members="${members}" />

</t:basepage>