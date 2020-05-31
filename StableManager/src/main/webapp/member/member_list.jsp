<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">
    <jsp:attribute name="pageHeader">
        <t:pagedescription title="Employés > Liste" />
    </jsp:attribute>


    <jsp:body>
        <s:form action="list_applyfilter" namespace="/member" class="members-list-filter-form">
            <div class="input-field col s12">
                <s:select label="Filtrer par rôle"
                          name="selectedRole"
                          list="roles"
                          listKey="name"
                          listValue="name"
                          emptyOption="true"
                          value="%{selectedRole}" />
                <label>Filtrer par rôle</label>
            </div>
            <button class="btn waves-effect waves-light" type="submit">
                Filtrer
                <i class="material-icons right">filter_alt</i>
            </button>
        </s:form>

        <t:memberlist members="${members}" />
    </jsp:body>

</t:basepage>