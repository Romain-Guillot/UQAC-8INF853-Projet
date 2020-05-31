<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:basepage pageTitle="StableManager">
    <jsp:attribute name="pageHeader">
        <t:pagedescription title="Employés > Edition > ${user.id}" />
    </jsp:attribute>


    <jsp:body>
        <h2>Information générales</h2>
        <s:form action="perform_edit/%{member.id}" namespace="/member">
            <s:hidden name="member.password" />
            <s:hidden name="member.registerAt" />
            <div class="input-field">
                <s:textfield name="member.firstName" label="Prénom" id="firstname"/>
                <label for="firstname">Prénom</label>
            </div>
            <div class="input-field">
                <s:textfield name="member.lastName" label="Nom" id="lastname"/>
                <label for="lastname">Nom</label>
            </div>
            <div class="input-field">
                <s:textfield name="member.email" label="Email" id="email"/>
                <label for="email">Email</label>
            </div>
            <div class="input-field">
                <s:textfield name="member.postalAddress" label="Adresse postale" id="address"/>
                <label for="address">Prénom</label>
            </div>
            <div class="input-field">
                <s:textfield name="birthDate" label="Date de naissance" id="birthdate" class="datepicker" />
                <label for="birthdate">Date de naissance</label>
            </div>
            <button class="btn waves-effect waves-light" type="submit">
                Mettre à jour
                <i class="material-icons right">send</i>
            </button>
        </s:form>

        <h2>Mot de passe</h2>
        <s:form action="perform_changepassword/%{member.id}" namespace="/member">
            <div class="input-field">
                <s:textfield name="newPassword" label="Nouveau mot de passe" id="password"/>
                <label for="password">Nouveau mot de passe</label>
            </div>
            <button class="btn waves-effect waves-light" type="submit">
                Modifier le mot de passe
                <i class="material-icons right">send</i>
            </button>
        </s:form>
    </jsp:body>
</t:basepage>