<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <jsp:attribute name="pageHeader">
            <t:pagedescription title="Chevaux > Liste">
                <a href="<s:url action='create' namespace="/horse"/>" class="waves-effect waves-light btn">Ajouter un cheval</a>
            </t:pagedescription>
    </jsp:attribute>

    <jsp:body>
        <div>
            <s:form action="search" namespace="/horse">
                <div class="input-field  col s12">
                    <s:textfield name="horseFilter.horseName" id="search" />
                    <label for="search">Recherher</label>
                </div>
                <button class="btn waves-effect waves-light" type="submit">
                    Rechercher
                    <i class="material-icons right">filter_alt</i>
                </button>
            </s:form>
            <a href="<s:url action="search" namespace="/horse"/>">Recherche avancée</a>
        </div>
        <t:horselist horses="${horses}"  />
    </jsp:body>
</t:basepage>