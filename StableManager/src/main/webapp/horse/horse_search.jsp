<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <jsp:attribute name="pageHeader">
            <t:pagedescription title="Chevaux > Recherche" />
    </jsp:attribute>

    <jsp:body>
        <div>
            <s:form action="search" namespace="/horse">
                <div class="input-field">
                    <s:textfield name="horseFilter.horseName" id="search"/>
                    <label for="search">Recherher</label>
                </div>
                <div class="input-field">
                    <s:textfield name="horseFilter.owner" id="owner"/>
                    <label for="owner">Propriétaire</label>
                </div>
                <div class="input-radio">
                    <label>Associé à des locations : </label>
                    <s:radio  name="linkedWithBookings" list="#{'1':'Oui','2':'Non', '3': 'Indifférent'}"  />
                </div>
                <button class="btn waves-effect waves-light" type="submit">
                    Rechercher
                    <i class="material-icons right">filter_alt</i>
                </button>
            </s:form>
        </div>

        <t:horselist horses="${horses}"  />
    </jsp:body>
</t:basepage>