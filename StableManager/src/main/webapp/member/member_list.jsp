<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <t:pagedescription title="Employés" >
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

    <ul>
        <s:iterator value="members">
            <s:set value="id" var="memberID"/>
            <li>
                <a href="<s:url action='view/%{#memberID}' namespace='/member'/> ">
                    <p>${firstName} ${lastName}</p>
                    <p>${accountType} - ${role.name}</p>
                </a>
            </li>
        </s:iterator>
    </ul>

</t:basepage>