<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">
    <jsp:attribute name="pageHeader">
        <t:pagedescription title="Sécurité > Rôle > Edition > ${roleName}"  />
    </jsp:attribute>


    <jsp:body>


        <h2>Information générales</h2>
        <s:form action="perform_edition" method="post">
            <s:hidden name="roleName" value="%{roleName}"/>
            <div class="input-field">
                <s:textfield key="role.name" label="Nom" id="name"/>
                <label for="name">Nom</label>
            </div>
            <div class="input-field">
                <s:textfield key="role.description" label="Nom" id="description"/>
                <label for="description">Description</label>
            </div>
            <div class="input-field input-field-select">
                <label for="rights">Privilèges</label>
                <s:select
                        label="Privilèges"
                        list="permissions"
                        listKey="name"
                        listValue="name"
                        multiple="true"
                        key="selectedPermissions"
                        value="%{role.rights.{name}}"
                        id="rights"/>
            </div>
            <button class="btn waves-effect waves-light" type="submit">
                Valider
                <i class="material-icons right">send</i>
            </button>
        </s:form>
    </jsp:body>
</t:basepage>